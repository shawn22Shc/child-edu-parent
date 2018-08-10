package com.xsx.ce.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.xsx.ce.mapper.XsxChildInfoMapper;
import com.xsx.ce.mapper.XsxContentChildrenMapper;
import com.xsx.ce.mapper.XsxUserMapper;
import com.xsx.ce.mapper.ext.ReMapperExt;
import com.xsx.ce.pojo.*;
import com.xsx.ce.pojo.ext.ReLittleTag;
import com.xsx.ce.pojo.ext.ReUserTag;
import com.xsx.ce.service.*;
import com.xsx.ce.util.redis.constant.ConstantForRedis;
import com.xsx.ce.util.score.ScoreUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.*;

/**
 * @Author： shawn
 * @Description： 行为处理   观看历史 处理为 用户标签   课程标签
 * @Date： Create in 13:38 2018/6/22
 * @ModifiedBy:
 */

@Service
public class ReActionHandleServiceImpl implements ReActionHandleService {

    @Autowired
    private ReWatchLogService watchLogService;

    @Autowired
    private XsxContentChildrenMapper littleMapper;

    @Autowired
    private ReUserTagService userTagService;

    @Autowired
    private XsxChildInfoMapper childInfoMapper;

    @Autowired
    private ReMapperExt userMapperExt;

    @Autowired
    private XsxUserMapper userMapper;

    @Autowired
    private ReTimeScoreService reTimeScoreService;

    @Autowired
    private ReTagLittleService littleService;

    /*@Autowired
    private XsxContentTagMapper tagMapper;*/

     /*@Autowired
    private UserStatusService userStatusService;*/

    @Autowired
    private JedisPool pool;

    private static final int pageSize = 1000;

    private static final String emptyValue = "";

    private static final String splitStr = ",";

    @Override
    public int handleUserTag() {
        long start = new Date().getTime();
        int flag = 0;
        int totalCount = userMapper.countByExample(null);
        int count = totalCount%pageSize > 0 ? (totalCount/pageSize)+1 : (totalCount/pageSize);
        //  用户 ids
        delTagIdsString();
        for (int i = 1; i <= count ; i++) {
            PageHelper.startPage(i,pageSize);
            List<Long> ids = userMapperExt.selectUserIds();
            //处理 每个人
            for (Long userId :ids) {
                System.out.println( " userId :"+userId+" start");
                int result = handleUserTagByUserId(userId);
                flag += result;
            }
        }
        delTagIdsString();
        System.out.println( "error Count :" + flag );
        long end = new Date().getTime();
        long useTime = end - start;
        System.out.println("useTime  ms:"+useTime+" s:"+(useTime/1000)+" min:"+ ((useTime/1000)/60));
        return flag;
    }

    @Override
    public int handleLittleTag() {
        long start = new Date().getTime();
        int flag = 0;
        int totalCount = littleMapper.countByExample(null);
        int count = totalCount%pageSize > 0 ? (totalCount/pageSize)+1 : (totalCount/pageSize);
        //  用户 ids
        delTagIdsString();
        for (int i = 1; i <= count ; i++) {
            PageHelper.startPage(i,pageSize);
            List<Long> ids = userMapperExt.selectLittleIds();
            //处理 每个课
            for (Long littleId :ids) {
                System.out.println( " littleId :"+littleId+" start");
                int result = handleLittelTagByLittleId(littleId);
                flag += result;
            }
        }
        delTagIdsString();
        long end = new Date().getTime();
        long useTime = end - start;
        System.out.println("error Count :" + flag );
        System.out.println("useTime  ms:"+useTime+" s:"+(useTime/1000)+" min:"+ ((useTime/1000)/60));
        return 0;
    }

    //----------------------------private----------------------------

    /**
     * 处理 某个 小课
     * @param littleId
     * @return
     */
    private int handleLittelTagByLittleId( Long littleId ){
        int result = 0;
        try {
            ReTagLittle tagLittle = littleService.getReTagLittleByLittleId(littleId);
            //System.out.println(" tagLittle :"+tagLittle);
            if (tagLittle == null ){
                return 0;
            }
            handleLogForLittleTag(tagLittle);
        }catch (Exception e) {
            e.printStackTrace();
            result = 1;
        }
        return result;
    }


    /**
     * 小课 阅读历史 处理
     * @param tagLittle
     */
    private void handleLogForLittleTag(ReTagLittle tagLittle){
        //time 在下方 update
        long time = new Date().getTime();
        //tagLittle.setTagids(tagIds);
        //在 下个 方法里 set吧
        Map<Long, ReLittleTag> map = littleService.getReLittleTag(tagLittle);
        int totalCount = watchLogService.getLittleWatchLogCount(tagLittle.getLittleId() ,tagLittle.getTime());
        int count = totalCount%pageSize > 0 ? (totalCount/pageSize)+1 : (totalCount/pageSize);
        //System.out.println(" count :"+totalCount+":"+count );
        for (int i = 1; i <= count ; i++) {
            List<ReWatchLog> list = watchLogService.getVideoWatchlog(i,pageSize,tagLittle.getLittleId(),tagLittle.getTime());
            for (ReWatchLog log: list) {
                long score = reTimeScoreService.getScore(log.getTime());
                Long userId = log.getUserId();
                Set<Long> userTagIds = getUserTagIds( userId);
                //System.out.println("-------------------???-----"+userTagIds.size());
                for (Long tagId:userTagIds) {
                    //System.out.println(" user :"+log.getUserId()+" tagId :"+tagId);

                    if (tagId.longValue() <= 22){
                        ReLittleTag littleTag = map.get(tagId);
                        if ( littleTag == null ){
                            littleTag = new ReLittleTag();
                            littleTag.setTg(tagId);
                            littleTag.setTm(log.getTime());
                            long scoreNew = ScoreUtil.getLittleTagScore(1l,0l,log.getTime());
                            littleTag.setSc(scoreNew);
                            littleTag.setHt(1l);
                            map.put(tagId,littleTag);
                        }else {
                            long oldTime = littleTag.getTm();
                            long oldScore = littleTag.getSc();
                            long oldHit = littleTag.getHt();
                            long oldTagId = littleTag.getTg();
                            littleTag.setTg(oldTagId);
                            littleTag.setHt(oldHit+1l);
                            littleTag.setTm(oldTime+log.getTime());
                            long scoreNew = ScoreUtil.getLittleTagScore(littleTag.getHt(),oldScore,log.getTime());
                            littleTag.setSc(scoreNew);
                            map.put(tagId,littleTag);
                        }
                    }else {
                        continue;
                    }
                }
            }
        }
        Gson gson = new Gson();
        String content = gson.toJson(map);
        tagLittle.setContent(content);
        tagLittle.setTime(time);
        littleService.updateReTagLittle(tagLittle);
    }

    /**
     * 获取 人标签 redis - -别忘了删。
     * @param userId
     * @return
     */
    private Set<Long> getUserTagIds(Long userId){
        Set<Long> tagIds = new HashSet<>();
        String idsString = getUserTagIdsString(userId);
        if (StringUtils.isNotEmpty(idsString)){
            String[] tagStrIds = idsString.split(splitStr);
            for (String tagStr:tagStrIds) {
                try {
                    Long tagId = Long.parseLong(tagStr);
                    tagIds.add(tagId);
                }catch (Exception e){
                    System.out.println("UserTag tagStr 转  Long  出现异常  tagStr:"+tagStr+";");
                }
            }
        }
        return tagIds;
    }

    /**
     * 清除 redis
     */
    private void delTagIdsString(){
        Jedis jedis = pool.getResource();
        try {
            String key1 = ConstantForRedis.RE_USER_TAG_IDS;
            jedis.del(key1);
            String key2 = ConstantForRedis.RE_LITTLE_TAG_IDS;
            jedis.del(key2);
        }finally {
            jedis.close();
        }
    }

    /**
     * 通过 userId 找到 找到年龄 性别 存在了 redis中
     *  如果redis 有问题 则可以只改变这个方法
     * @param userId
     * @return
     */
    private String getUserTagIdsString(Long userId){
        Jedis jedis = pool.getResource();
        try {
            String key = ConstantForRedis.RE_USER_TAG_IDS;
            String field = String.valueOf(userId);
            if (jedis.hexists(key,field)) {
                return jedis.hget(key,field);
            } else {
                // 用户 childInfo
                XsxChildInfo childInfo = childInfoMapper.selectByPrimaryKey(userId);
                if (childInfo == null){
                    return null;
                } else {
                    String tagValue = emptyValue;
                    if (childInfo.getAge() != null){
                        tagValue = tagValue + splitStr+String.valueOf(childInfo.getAge());
                    }
                    if (childInfo.getGender() != null){
                        tagValue = tagValue + splitStr+String.valueOf(childInfo.getGender());
                    }
                    if (StringUtils.isEmpty(tagValue)) {
                        jedis.hset(key,field,emptyValue);
                    }else {
                        jedis.hset(key,field,tagValue);
                    }
                    return tagValue;
                }
            }
        }finally {
            jedis.close();
        }
    }

    /**
     *
     * @param userId
     * @return 0 正常  1出现异常
     */
    private int handleUserTagByUserId(Long userId ){
        int result = 0;

        try {
            ReTagUser tagUser = userTagService.getReTagUserByUserId(userId);
            if (tagUser == null) {
                return 0;
            }
            //根据 历史行为
            handleLogForUserTag(tagUser);
        }catch (Exception e){
            e.printStackTrace();
            result = 1;
        }
        return result;
    }

    //处理 历史记录 并且 修改 人物标签
    private void handleLogForUserTag(ReTagUser tagUser){
        long time = new Date().getTime();
        Map<Long, ReUserTag> map = userTagService.getReUserTagMap(tagUser.getContent());
        int totalCount = watchLogService.getUserWatchLogCount(tagUser.getUserId() ,tagUser.getTime());
        int count = totalCount%pageSize > 0 ? (totalCount/pageSize)+1 : (totalCount/pageSize);
        //处理 历史
        for (int i = 1; i <= count ; i++) {
            // 观看历史
            List<ReWatchLog> list = watchLogService.getUserWatchlog(i,pageSize,tagUser.getUserId(),tagUser.getTime());
            for (ReWatchLog log: list) {
                long score = reTimeScoreService.getScore(log.getTime());
                Long littleId = log.getLittleId();
                //
                Set<Long> tagIds = getLittleTagIds(littleId);
                for (Long tagId:tagIds) {
                    //年龄性别 标签
                    if (tagId.longValue() <= 22){
                        continue;
                    }
                    ReUserTag reUserTag = map.get(tagId);
                    if ( reUserTag != null ) {
                        long oldTime = reUserTag.getTm();
                        long oldScore = reUserTag.getSc();
                        long oldPush = reUserTag.getPh();
                        long oldHit = reUserTag.getHt();
                        long oldTagId = reUserTag.getTg();
                        reUserTag.setTg(oldTagId);
                        reUserTag.setHt(oldHit+1l);
                        reUserTag.setPh(oldPush);
                        reUserTag.setTm(oldTime+log.getTime());
                        //long scoreNew = ScoreUtil.getUserTagScore(reUserTag.getHt(),reUserTag.getPh(),oldScore,reUserTag.getTm());
                        //reUserTag.setSc(scoreNew);
                        map.put(tagId,reUserTag);
                    }else {
                        reUserTag = new ReUserTag();
                        reUserTag.setTm(log.getTime());
                        //long scoreNew = ScoreUtil.getUserTagScore(1l,0l,0l,log.getTime());
                        //reUserTag.setSc(scoreNew);
                        reUserTag.setPh(0l);
                        reUserTag.setHt(1l);
                        reUserTag.setTg(tagId);
                        map.put(tagId,reUserTag);
                    }

                }
            }
        }
        //重新 打一遍分？
        for (Long tagId: map.keySet() ) {
            if (tagId.longValue() <= 22l){
                continue;
            }
            ReUserTag reUserTag = map.get(tagId);
            if (reUserTag == null){
                reUserTag = new ReUserTag();
                reUserTag.setTm(0l);
                reUserTag.setPh(0l);
                reUserTag.setHt(0l);
                reUserTag.setSc(0l);
                reUserTag.setTg(tagId);

            }
            long scoreNew = ScoreUtil.getUserTagScore(reUserTag.getHt(),reUserTag.getPh(),reUserTag.getSc(),reUserTag.getTm());
            reUserTag.setSc(scoreNew);
            map.put(tagId,reUserTag);
            //System.out.println("-----------user  score -- userId:"+tagUser.getUserId()+"----tagId:"+tagId+"---score:"+reUserTag.getSc());
        }
        userTagService.updataReTagUser(tagUser.getUserId() , map , time);
    }

    /**
     * 获取 小课的 tagIds
     * @param littleId
     * @return
     */
    private Set<Long> getLittleTagIds(Long littleId){
        Set<Long> tagIds = new HashSet<>();
        String idsString = getLittleTagIdsString(littleId);
        if (StringUtils.isNotEmpty(idsString)){
            String[] tagStrIds = idsString.split(splitStr);
            for (String tagStr:tagStrIds) {
                try {
                    Long tagId = Long.parseLong(tagStr);
                    tagIds.add(tagId);
                }catch (Exception e){
                    System.out.println("LittleTag  tagStr 转  Long  出现异常  tagStr:"+tagStr+";");
                }
            }
        }
        return tagIds;
    }

    /**
     * 通过 小课Id 找到 对应的所有标签Str  存在了 redis中
     *  如果redis 有问题 则可以只改变这个方法
     * @param littleId
     * @return
     */
    private String getLittleTagIdsString(Long littleId){
        Jedis jedis = pool.getResource();
        try {
            String key = ConstantForRedis.RE_LITTLE_TAG_IDS;
            String field = String.valueOf(littleId);
            if (jedis.hexists(key,field)) {
                return jedis.hget(key,field);
            } else {
                // 修改策略 放在我自己处理的地方了
                ReTagLittle little = littleService.getReTagLittleByLittleId(littleId);
                if (little == null){
                    return null;
                } else {
                    String tagValue = little.getTagids();
                    if (tagValue == null) {
                        jedis.hset(key,field,emptyValue);
                    }else {
                        jedis.hset(key,field,tagValue);
                    }
                    return tagValue;
                }
                // 不使用一下这种 因为数据表 不在re中
                /*XsxContentChildren little = littleMapper.selectByPrimaryKey(littleId);
                if (little == null){
                    return null;
                } else {
                    String tagValue = little.getTag();
                    if (tagValue == null) {
                        jedis.hset(key,field,emptyValue);
                    }else {
                        jedis.hset(key,field,tagValue);
                    }
                    return little.getTag();
                }*/
            }
        }finally {
            jedis.close();
        }
    }

}
