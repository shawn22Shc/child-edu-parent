package com.xsx.ce.service;

/**
 * @Author： shawn
 * @Description： 用户推荐list
 * @Date： Create in 16:21 2018/6/27
 * @ModifiedBy:
 */


public interface ReUserListService {

    int updateOrCreateUserLittleList( Long userId,String ids);

}
