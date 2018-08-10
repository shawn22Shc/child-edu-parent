package com.xsx.ce.service.impl;

import com.xsx.ce.mapper.ReUserStatusMapper;
import com.xsx.ce.mapper.XsxChildInfoMapper;
import com.xsx.ce.mapper.XsxUserMapper;
import com.xsx.ce.pojo.ReUserStatus;
import com.xsx.ce.pojo.XsxChildInfo;
import com.xsx.ce.pojo.XsxUserExample;
import com.xsx.ce.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 18:32 2018/6/8
 * @ModifiedBy:
 */
@Service
public class UserStatusServiceImpl implements UserStatusService {

    @Autowired
    private XsxUserMapper userMapper;

    @Autowired
    private XsxChildInfoMapper childInfoMapper;

    @Autowired
    private ReUserStatusMapper userStatusMapper;

    @Override
    public List<Long> getUserIds(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public ReUserStatus getUserStatus(Long userId) {
        ReUserStatus userStatus = userStatusMapper.selectByPrimaryKey(userId);
        if(userStatus == null){
            userStatus = initReUserState(userId);
        }
        return userStatus;
    }

    @Override
    public boolean userExit(Long userId){
        XsxUserExample ex = new XsxUserExample();
        ex.createCriteria().andIdEqualTo(userId);
        int count = userMapper.countByExample(ex);
        return (count == 0) ? false:true;
    }

    @Override
    public int updateUserStatus(ReUserStatus reUserStatus) {
        return userStatusMapper.updateByPrimaryKey(reUserStatus);
    }

    //-------------------------private------------------------------

    /**
     * 初始化用户状态
     * @param userId
     * @return 用户不存在返回null
     */
    private ReUserStatus initReUserState(Long userId){
        if(userExit(userId)){
            ReUserStatus userStatus = new ReUserStatus();
            userStatus.setUserId(userId);
            //默认状态 启动推荐
            userStatus.setStatus(1);
            //初始化 没有推荐过
            userStatus.setRoundCount(0);
            userStatus.setNowRoundStatus(0);
            userStatus.setReId(0);
            //childInfo
            XsxChildInfo childInfo = childInfoMapper.selectByPrimaryKey(userId);
            if(childInfo != null){
                userStatus.setAge(childInfo.getAge());
                userStatus.setGender(childInfo.getGender());
            }
            userStatusMapper.insertSelective(userStatus);
            return userStatusMapper.selectByPrimaryKey(userId);
        }
        return null;
    }

}
