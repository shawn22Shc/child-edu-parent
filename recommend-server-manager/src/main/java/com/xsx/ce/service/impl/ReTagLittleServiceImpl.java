package com.xsx.ce.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xsx.ce.mapper.ReTagLittleMapper;
import com.xsx.ce.mapper.XsxContentChildrenMapper;
import com.xsx.ce.mapper.XsxContentMapper;
import com.xsx.ce.pojo.ReTagLittle;
import com.xsx.ce.pojo.XsxContent;
import com.xsx.ce.pojo.XsxContentChildren;
import com.xsx.ce.pojo.XsxContentChildrenExample;
import com.xsx.ce.pojo.ext.ReLittleTag;
import com.xsx.ce.service.ReTagLittleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 13:53 2018/6/25
 * @ModifiedBy:
 */

@Service
public class ReTagLittleServiceImpl implements ReTagLittleService {

    @Autowired
    private ReTagLittleMapper tagLittleMapper;

    @Autowired
    private XsxContentChildrenMapper childrenMapper;

    @Autowired
    private XsxContentMapper bigMapper;

    private static final String emptyValue = "";

    private static final String splitStr = ",";

    @Override
    public Map<Long, ReLittleTag> getReLittleTag(Long littleId) {
        ReTagLittle tagLittle = getReTagLittleByLittleId(littleId);
        if (tagLittle == null) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Long, ReLittleTag>>() {}.getType();
        Map<Long, ReLittleTag> map = gson.fromJson(tagLittle.getContent(),type);
        return map;
    }

    @Override
    public Map<Long, ReLittleTag> getReLittleTag(String content) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Long, ReLittleTag>>() {}.getType();
        Map<Long, ReLittleTag> map = gson.fromJson(content,type);
        return map;
    }


    @Override
    public Map<Long, ReLittleTag> getReLittleTag(ReTagLittle tagLittle) {
        if (tagLittle == null){
            return null;
        }
        Map<Long, ReLittleTag> map = getReLittleTag(tagLittle.getContent());
        Iterator<Long> iter = map.keySet().iterator();
        while(iter.hasNext()){
            Long key = iter.next();
            if(key.longValue() >= 22l){
                iter.remove();
            }
        }
        XsxContentChildren little = childrenMapper.selectByPrimaryKey(tagLittle.getLittleId());
        if (little != null) {
            String idsStr = emptyValue;
            String littleIds = little.getTag();
            if (StringUtils.isNotEmpty( littleIds )) {
                // 处理  小课标签
                idsStr = idsStr+littleIds;
                setReLittleTagToMapByIds(map,littleIds);
            }
            if (little.getContentId() != null){
                XsxContent big = bigMapper.selectByPrimaryKey(little.getContentId());
                if (big != null ){
                    String bigIds = big.getTag();
                    if (StringUtils.isNotEmpty(bigIds)) {
                        idsStr = idsStr+bigIds;
                        setReLittleTagToMapByIds(map,bigIds);
                    }
                }
            }
            tagLittle.setTagids(idsStr);
        }
        return map;
    }

    @Override
    public ReTagLittle getReTagLittleByLittleId(Long littleId) {
        ReTagLittle tagLittle = tagLittleMapper.selectByPrimaryKey(littleId);
        if (tagLittle == null) {
            tagLittle = initReTagLittle( littleId );
        }
        return tagLittle;
    }

    @Override
    public void updateReTagLittle(ReTagLittle reTagLittle) {
        //TODO 到底要不要加个 校验啊
        tagLittleMapper.updateByPrimaryKey(reTagLittle);
    }

    @Override
    public void updataReTagLittle(Long littleId, Map<Long, ReLittleTag> map, long time) {
        Gson gson = new Gson();
        String content = gson.toJson(map);
        ReTagLittle tagLittle = new ReTagLittle();
        tagLittle.setLittleId(littleId);
        tagLittle.setContent(content);
        tagLittle.setTime(time);
        updateReTagLittle(tagLittle);
    }

    @Override
    public ReTagLittle initReTagLittle(Long littleId) {
        if (littleExit(littleId)){
            ReTagLittle tagLittle = new ReTagLittle();
            //TODO  在这个方法中 将ids 加了进去- -
            Map<Long ,ReLittleTag> map = getLittleTagMap(littleId, tagLittle);
            tagLittle.setLittleId(littleId);
            tagLittle.setTime(0l);
            Gson gson = new Gson();
            tagLittle.setContent(gson.toJson(map));
            tagLittleMapper.insert(tagLittle);
            return tagLittle;
        }else {
            return null;
        }
    }

    //-----------------------------------------private-----------------------------------

    /**
     * 获取 小课 的标签  初始化而已
     * @param littleId
     * @return
     */
    private Map<Long ,ReLittleTag> getLittleTagMap(Long littleId,ReTagLittle tagLittle){
        XsxContentChildren little = childrenMapper.selectByPrimaryKey(littleId);
        if (little != null) {
            String idsStr = emptyValue;
            Map<Long ,ReLittleTag> map = new HashMap<>();
            String littleIds = little.getTag();
            if (StringUtils.isNotEmpty( littleIds )) {
                // 处理  小课标签
                idsStr = idsStr+littleIds;
                setReLittleTagToMapByIds(map,littleIds);
            }
            if (little.getContentId() != null){
                XsxContent big = bigMapper.selectByPrimaryKey(little.getContentId());
                if (big != null ){
                    String bigIds = big.getTag();
                    if (StringUtils.isNotEmpty(bigIds)) {
                        idsStr = idsStr+bigIds;
                        //处理 大课标签
                        setReLittleTagToMapByIds(map,bigIds);
                    }
                }
            }
            tagLittle.setTagids(idsStr);
            return map;
        }else {
            return null;
        }
    }

    /**
     * 把字符串拆分成id 存入map
     * @param map
     * @param ids
     */
    private void setReLittleTagToMapByIds(Map<Long ,ReLittleTag> map,String ids){
        String[] idsString = ids.split(splitStr);
        for (String idStr:idsString) {
            try {
                Long tagId = Long.parseLong(idStr);
                // 必须是 大于 22的。
                if (tagId > 22l) {
                    ReLittleTag littleTag = new ReLittleTag();
                    littleTag.setHt(0l);
                    littleTag.setSc(1l);
                    littleTag.setTg(tagId);
                    littleTag.setTm(0l);
                    map.put(tagId,littleTag);
                }
            }catch (Exception e){
                System.out.println(" idStr 转  Long  出现异常  idStr:"+idStr+";");
            }

        }
    }


    /**
     * 小课是否存在
     * @param littleId
     * @return
     */
    private boolean littleExit(Long littleId) {
        XsxContentChildrenExample example = new XsxContentChildrenExample();
        example.createCriteria().andIdEqualTo(littleId);
        int count = childrenMapper.countByExample(example);
        return (count == 0 ) ? false : true;
    }

}
