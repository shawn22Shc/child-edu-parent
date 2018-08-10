package com.xsx.ce.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.hash.BloomFilter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xsx.ce.mapper.XsxContentChildrenMapper;
import com.xsx.ce.mapper.XsxUserMapper;
import com.xsx.ce.mapper.ext.ReMapperExt;
import com.xsx.ce.pojo.ReRoundProportion;
import com.xsx.ce.pojo.ReTagLittle;
import com.xsx.ce.pojo.ReTagUser;
import com.xsx.ce.pojo.ReUserStatus;
import com.xsx.ce.pojo.ext.ReLittleTag;
import com.xsx.ce.pojo.ext.ReScoreExpandProp;
import com.xsx.ce.pojo.ext.ReUserTag;
import com.xsx.ce.service.*;
import com.xsx.ce.util.BloomFilterUtils;
import com.xsx.ce.util.redis.constant.ConstantForRedis;
import com.xsx.ce.util.score.ScoreModel;
import com.xsx.ce.util.similarity.CosineSimilarityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 9:49 2018/6/26
 * @ModifiedBy:
 */

@Service
public class ReProduceServiceImpl implements ReProduceService {

    @Autowired
    private ReMapperExt userMapperExt;

    @Autowired
    private XsxUserMapper userMapper;

    @Autowired
    private UserStatusService userStatusService;

    @Autowired
    private ReParameterService parameterService;

    @Autowired
    private ReStatusService statusService;

    @Autowired
    private XsxContentChildrenMapper littleMapper;
    
    @Autowired
    private ReTagLittleService tagLittleService;

    @Autowired
    private ReUserTagService tagUserService;

    @Autowired
    private ReUserListService reUserListService;

    @Autowired
    private ReArtificialTopService reArtificialTopService;

    @Autowired
    private ReArtificialCourseService reArtificialCourseService;

    @Autowired
    private JedisPool pool;

    private static final int pageSize = 1000;

    private static final String emptyValue = "";

    private static final String splitStr = ",";

    @Override
    public int produceUserReList() {
        // 总体不可用状态
        if (  !statusService.getReStatus() ){
            return -1;
        }
        //记得删redis
        deleteLittleTagMapStr();
        long start = new Date().getTime();
        int flag = 0;
        int totalCount = userMapper.countByExample(null);
        int count = totalCount%pageSize > 0 ? (totalCount/pageSize)+1 : (totalCount/pageSize);
        for (int i = 1 ; i <= count ; i++){
            PageHelper.startPage(i,pageSize);
            List<Long> userIds = userMapperExt.selectUserIds();
            //处理 每个人
            for (Long userId :userIds) {
                System.out.println( " userId :"+userId+" start");
                int result = makeReListByUserId(userId);
                flag += result;
            }
        }
        //记得删redis
        deleteLittleTagMapStr();
        long end = new Date().getTime();
        long useTime = end - start;
        System.out.println("error Count :" + flag );
        System.out.println("useTime  ms:"+useTime+" s:"+(useTime/1000)+" min:"+ ((useTime/1000)/60));
        return 0;
    }

    //---------------------------private-----------------------------------------------

    /**
     * 每个 人 生产 reList
     * @param userId
     * @return
     */
    private int makeReListByUserId(Long userId ) {
        int result = 0;
        try {
            //用户状态
            ReUserStatus us = userStatusService.getUserStatus(userId);
            if (us == null ){
                return 1;
            }
            //该用户状态为 1 才可以推荐
            if (us.getStatus().intValue() != 1) {
                return 0;
            }
            //本轮状态
            int roundStatus = us.getNowRoundStatus();
            /*if (roundStatus == -1){
                System.out.println("上一轮 一次 都没 推荐过？？");
                return 0;
            }*/
            if (roundStatus != 1) {
                // 未完成 上一轮
                // 看看 推荐间隔。是否超过  最大间隔 如果未超过 则不生成
                long maxTime = parameterService.getMaxReListProduceTime();
                long now = new Date().getTime();
                if (  (now-us.getReTime().longValue()) <= maxTime  ) {
                    return 0;
                }
            }
            long now = new Date().getTime();
            getUserReListStr(us);
            // ue 应该 round +1  now_round_status 修改
            us.setNowRoundStatus(-1);
            us.setReTime(now);
            int oldRound = us.getRoundCount();
            us.setRoundCount(oldRound+1);
            userStatusService.updateUserStatus(us);
        }catch (Exception e){
            e.printStackTrace();
            result = 1;
        }
        return result;
    }

    /**
     * 来吧 list
     *  分成 三 步吧 卧槽
     * 1 余弦相似度 排序  littleScoreSet
     * 2 有用户未有/推荐较少 的标签 newTagSet
     * 3 系统推荐 list
     * 根据这三个 list 生成最后的
     * @param userStatus
     */
    private void getUserReListStr(ReUserStatus userStatus){
        Map<Long,ReUserTag> userTagMap = tagUserService.getReUserTag(userStatus.getUserId());
        if (userTagMap == null) {
            return;
        }
        // 余弦相似度排序list
        Set<ScoreModel> littleScoreSet = new TreeSet<>();
        // 推荐较少 标签 推荐
        Set<ScoreModel> newTagSet = new TreeSet<>();
        //分页查询
        int totalCount = littleMapper.countByExample(null);
        int count = totalCount%pageSize > 0 ? (totalCount/pageSize)+1 : (totalCount/pageSize);
        for (int i = 1; i <= count ; i++) {
            PageHelper.startPage(i,pageSize);
            List<Long> ids = userMapperExt.selectLittleIds();
            //处理 每个课
            for (Long littleId :ids) {
                Map<Long, ReLittleTag> littleTagMap = getLittleTagMap(littleId);
                if (littleTagMap == null) {
                    continue;
                }
                // 1: 相似度 排序
                double simScore = checkLittleSimScore(littleTagMap,userTagMap);
                littleScoreSet.add(new ScoreModel(littleId,simScore));
                // 2: 未接触过 评分
                double newTagScore = chechLittleNewTagScore(littleTagMap,userTagMap);
                newTagSet.add(new ScoreModel(littleId,newTagScore));
            }
        }
        //最后  生成的推荐列表
        List<Long> reLittleIdList = getLittleIdList(userStatus,littleScoreSet,newTagSet);
        for (Long littleId : reLittleIdList) {
            updateUserTagMap(userTagMap,littleId);
        }
        //  修改啦  用户推荐列表
        updateUserReList(userStatus.getUserId(),reLittleIdList);
        //  修改啦  用户tag关系
        ReTagUser reTagUser = tagUserService.getReTagUserByUserId(userStatus.getUserId());
        Gson gson = new Gson();
        String newContent = gson.toJson(userTagMap);
        reTagUser.setContent(newContent);
        tagUserService.updateReTagUser(reTagUser);
    }

    /**
     * 根据 参数设置 获取 最后的list
     *  包括 比例 去重
     *  artifLittleList 人工推荐标签 list的原因 是可以 重新乱序排列吧 而且也是从数据库取出来的
     *  topLittleIdList 置顶推荐
     * @param userStatus
     * @param littleScoreSet  用户标签 相似度 符合标签 高到低
     * @param newTagSet 用户 未有 标签 推荐 课程
     * @return
     */
    private List<Long> getLittleIdList(ReUserStatus userStatus,Set<ScoreModel> littleScoreSet
            ,Set<ScoreModel> newTagSet){
        // 推荐 列表长度
        int reListSize = parameterService.getReListSize();
        ReRoundProportion roundProp = parameterService.getReRoundProportionByRound(userStatus.getRoundCount());
        int artPro = roundProp.getArtificialProportion();
        int sysPro = roundProp.getSystemProportion();
        //RePayOwnProp payProp = parameterService.getPayOwnProportion();
        int artifLittleSize = reListSize*artPro/(artPro+sysPro);

        int sysLittleSize = reListSize - artifLittleSize;
        ReScoreExpandProp seProp = parameterService.getReScoreExpandProp();
        int scorePro = seProp.getScore();
        int expandPro = seProp.getExpand();
        int expandSize = sysLittleSize*expandPro/(scorePro+expandPro);
        // 用户 按照 年龄 性别 生成 的 人工推荐列表
        //  人工推荐课程
        List<Long> artifLittleList = reArtificialCourseService.getReArtificialCourseList(artifLittleSize,userStatus.getAge(),userStatus.getGender());
        List<Long> result = new ArrayList<>();
        BloomFilter<Long> bloom = BloomFilterUtils.getLongBloomFilter();
        int count = 0;
        // 处理  人工推荐
        for (Long id:artifLittleList) {
            if (count >= artifLittleSize){
                break;
            }
            if( !bloom.mightContain(id)){
                bloom.put(id);
                result.add(id);
                count++;
            }
        }
        // 处理 系统推荐
        //拓展推荐
        count = 0;
        for(ScoreModel model:newTagSet) {
            if (count >= expandSize){
                break;
            }
            if( !bloom.mightContain(model.getId())){
                bloom.put(model.getId());
                result.add(model.getId());
                count++;
            }
        }
        //分数推荐
        int scoreList = sysLittleSize-count;
        count = 0;
        for(ScoreModel scoreModel:littleScoreSet) {
            //为什么吧分数放在最后呢。。
            if (count >= scoreList){
                break;
            }
            if( !bloom.mightContain(scoreModel.getId())){
                bloom.put(scoreModel.getId());
                result.add(scoreModel.getId());
                count++;
            }
        }
        Collections.shuffle(result);
        //  人工推荐置顶课程
        List<Long> topLittleIdList = reArtificialTopService.getReArtificialTopList();
        topLittleIdList.addAll(result);
        // 哎  再来一遍吧  要不咋整呢

        return topLittleIdList;
    }

    /**
     * 修改  用户推荐列表
     * @param userId
     * @param reLittleIdList
     */
    private void updateUserReList(Long userId,List<Long> reLittleIdList){
        StringBuilder idsBuilder = new StringBuilder(emptyValue);
        if (reLittleIdList != null && !reLittleIdList.isEmpty() ){
            for (Long littleId:reLittleIdList) {
                if (littleId != null ){
                    idsBuilder.append(String.valueOf(littleId)+splitStr);
                }
            }
        }
        reUserListService.updateOrCreateUserLittleList(userId,idsBuilder.toString());
    }


    /**
     * 更新 用户的标签 根据推荐的 新加
     * @param userTagMap
     * @param littleId
     */
    private void updateUserTagMap(Map<Long,ReUserTag> userTagMap,Long littleId ) {
        Map<Long, ReLittleTag> littleTagMap = getLittleTagMap(littleId);
        Set<Long> littleTagIdSet = littleTagMap.keySet();
        for (Long littleTagId:littleTagIdSet) {
            if (littleTagId.longValue() <= 22l){
                continue;
            }
            //System.out.println("  我要找77     "+littleTagId);
            if (userTagMap.containsKey(littleTagId) ){
                //System.out.println("  我要找77  if   "+littleTagId);
                ReUserTag userTag = userTagMap.get(littleTagId);
                long oldPush = userTag.getPh();
                userTag.setPh(oldPush + 1l);
                userTagMap.put(littleTagId,userTag);
            }else {
                //System.out.println("  我要找77  else   "+littleTagId);
                ReUserTag userTag = new ReUserTag();
                userTag.setPh(1l);
                userTag.setSc(0l);
                userTag.setTm(0l);
                userTag.setHt(0l);
                userTag.setTg(littleTagId);
                userTagMap.put(littleTagId,userTag);
            }
        }
    }

    /**
     * 计算 课程有个 标签中 用户 缺少多少
     * 或者 推荐 点击次数较少
     * 目前按照各自策略
     * 缺少的越多 分数越高
     * @param littleTagMap
     * @param userTagMap
     * @return
     */
    private double chechLittleNewTagScore(Map<Long, ReLittleTag> littleTagMap,Map<Long,ReUserTag> userTagMap) {
        double score = 0d;
        Set<Long> littleKeySet = littleTagMap.keySet();
        for (Long tagId: littleKeySet) {
            if (tagId.longValue() <= 22l){
                continue;
            }
            if ( !userTagMap.containsKey(tagId) ) {
                score += 10d;
                //System.out.println(" 没有 id："+tagId+" + 10");
            }else {
                ReUserTag userTag = userTagMap.get(tagId);
                if (userTag == null){
                    score += 1d;
                    //System.out.println(" null id："+tagId+" + 1");
                }else {
                    if ( userTag.getHt() < 5l && userTag.getPh() <5l){
                        score += 1d;
                        //System.out.println(" 小于5 id："+tagId+" + 1");
                    }
                }
            }
        }
        return score;
    }

    /**
     * 终于写到这了 哈哈哈哈哈哈哈
     * 根据  余弦相似度 获取 分数 用来排序
     * @param littleTagMap
     * @param userTagMap
     * @return
     */
    private double checkLittleSimScore(Map<Long, ReLittleTag> littleTagMap,Map<Long,ReUserTag> userTagMap) {
        return CosineSimilarityUtil.getUserLittleTagCosSimilarity(littleTagMap,userTagMap);
    }

    /**
     * 获取 小课的 tagmap redis中取
     * 记得删
     * @param littleId
     * @return
     */
    private Map<Long, ReLittleTag> getLittleTagMap(Long littleId){
        Map<Long, ReLittleTag> littleTagMap = null;
        try {
            String tagMapStr = getLittleTagMapStr(littleId);
            if (StringUtils.isEmpty(tagMapStr) ){
                return null;
            }
            Gson gson = new Gson();
            Type type = new TypeToken<Map<Long, ReLittleTag>>() {}.getType();
            littleTagMap = gson.fromJson(tagMapStr,type);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return littleTagMap;
    }

    /**
     * 推荐完成之后 删除redis
     */
    private void deleteLittleTagMapStr(){
        Jedis jedis = pool.getResource();
        try {
            jedis.del(ConstantForRedis.RE_LITTLE_TAG_MAP_STR);
        }finally {
            jedis.close();
        }
    }

    /**
     * redis 中 获取 / 填补 mapstr
     * @param littleId
     * @return
     */
    private String getLittleTagMapStr(Long littleId) {
        Jedis jedis = pool.getResource();
        try {
            String key = ConstantForRedis.RE_LITTLE_TAG_MAP_STR;
            String field = String.valueOf(littleId);
            if (jedis.hexists(key,field)) {
                return jedis.hget(key,field);
            }else {
                ReTagLittle tagLittle = tagLittleService.getReTagLittleByLittleId(littleId);
                String value = emptyValue;
                if (tagLittle != null){
                    if (tagLittle.getContent() != null){
                        value = tagLittle.getContent();
                    }
                }
                jedis.hset(key,field,value);
                return value;
            }
        }finally {
            jedis.close();
        }
    }

}