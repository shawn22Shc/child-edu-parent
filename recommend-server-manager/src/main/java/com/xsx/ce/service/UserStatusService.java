package com.xsx.ce.service;

import com.xsx.ce.pojo.ReUserStatus;

import java.util.List;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 18:04 2018/6/8
 * @ModifiedBy:
 */
public interface UserStatusService {

    /**
     * 按照分页 获取 用户 ids
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Long> getUserIds(int pageNum ,int pageSize);

    /**
     * 获取 用户状态
     * @param userId
     * @return 用户不存在 则返回null
     */
    ReUserStatus getUserStatus(Long userId );

    /**
     * 用户是否存在
     * @param userId
     * @return  true 存在 false 不存在
     */
    boolean userExit(Long userId);

    /**
     * 修改 re user status
     * @param reUserStatus
     * @return
     */
    int updateUserStatus(ReUserStatus reUserStatus);
}
