package com.xsx.ce.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xsx.ce.mapper.ReTagUserMapper;
import com.xsx.ce.mapper.XsxChildInfoMapper;
import com.xsx.ce.pojo.ReTagUser;
import com.xsx.ce.pojo.XsxChildInfo;
import com.xsx.ce.pojo.ext.ReUserTag;
import com.xsx.ce.service.ReUserTagService;
import com.xsx.ce.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 9:30 2018/6/21
 * @ModifiedBy:
 */

@Service
public class ReUserTagServiceImpl implements ReUserTagService {

    @Autowired
    private ReTagUserMapper reTagUserMapper;

    @Autowired
    private UserStatusService userStatusService;

    @Autowired
    private XsxChildInfoMapper childInfoMapper;

    @Override
    public Map<Long, ReUserTag> getReUserTag(Long userId) {
        ReTagUser tagUser = getReTagUserByUserId(userId);
        if (tagUser == null) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Long, ReUserTag>>() {}.getType();
        Map<Long, ReUserTag> map = gson.fromJson(tagUser.getContent(),type);
        return map;
    }

    @Override
    public Map<Long, ReUserTag> getReUserTagMap(String content) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Long, ReUserTag>>() {}.getType();
        Map<Long, ReUserTag> map = gson.fromJson(content,type);
        return map;
    }

    @Override
    public ReTagUser getReTagUserByUserId(Long userId) {
        ReTagUser reTagUser = reTagUserMapper.selectByPrimaryKey(userId);
        if ( reTagUser == null ){
            reTagUser = initReTagUser(userId);
        }
        return reTagUser;
    }

    @Override
    public void updateReTagUser(ReTagUser reTagUser) {
        // TODO
        reTagUserMapper.updateByPrimaryKeySelective(reTagUser);
    }

    @Override
    public void updataReTagUser(Long userId, Map<Long, ReUserTag> map ,long time) {
        Gson gson = new Gson();
        String content = gson.toJson(map);
        ReTagUser tagUser = new ReTagUser();
        tagUser.setUserId(userId);
        tagUser.setContent(content);
        tagUser.setTime(time);
        updateReTagUser(tagUser);
    }


    @Override
    public ReTagUser initReTagUser(Long userId) {
        if ( userStatusService.userExit(userId) ){
            Map<Long ,ReUserTag> map = getChildInfoTagMap(userId);
            // TODO
            Gson gson = new Gson();
            String content = gson.toJson(map);
            ReTagUser tagUser = new ReTagUser();
            tagUser.setUserId(userId);
            tagUser.setContent(content);
            tagUser.setTime(0l);
            reTagUserMapper.insert(tagUser);
            return tagUser;
        }else {
            return null;
        }
    }

    //--------------------------private----------------------------

    /**
     * 获取 用户的年龄 性别标签
     * @param userId
     * @return
     */
    private Map<Long ,ReUserTag> getChildInfoTagMap(Long userId){
        Map<Long ,ReUserTag> map = new HashMap<Long ,ReUserTag>();
        XsxChildInfo info = childInfoMapper.selectByPrimaryKey(userId);
        if ( info == null  ) {
            ReUserTag ageTag = new ReUserTag();
            ageTag.setTg(1l);
            ageTag.setHt(0);
            ageTag.setPh(0);
            ageTag.setSc(1);
            ageTag.setTm(1l);
            //年龄 key 恒定为1
            map.put(1l,ageTag);
            //--------------------------------性别-------------------------
            ReUserTag genderTag = new ReUserTag();
            genderTag.setTg(21l);
            genderTag.setHt(0);
            genderTag.setPh(0);
            genderTag.setSc(1);
            genderTag.setTm(1l);
            map.put(2l,genderTag);
        } else {
            //------------------------------年龄-------------------------
            ReUserTag ageTag = new ReUserTag();
            ageTag.setTg(info.getAge());
            ageTag.setHt(0);
            ageTag.setPh(0);
            ageTag.setSc(1);
            ageTag.setTm(1l);
            //年龄 key 恒定为1
            map.put(1l,ageTag);
            //--------------------------------性别-------------------------
            ReUserTag genderTag = new ReUserTag();
            genderTag.setTg(getGenderTagId(info.getGender()));
            genderTag.setHt(0);
            genderTag.setPh(0);
            genderTag.setSc(1);
            genderTag.setTm(1l);
            //性别 key 恒定为2
            map.put(2l,genderTag);
        }
        return map;
    }

    /**
     *
     * @param gender
     * @return
     */
    public long getGenderTagId(Integer gender ){
        if ( gender == null ) {
            return 21l;
        }
        if (gender.intValue() == 1){
            return 21l;
        } else if ( gender.intValue() == 0 ) {
            return 22l;
        } else {
            return 21l;
        }

    }

}
