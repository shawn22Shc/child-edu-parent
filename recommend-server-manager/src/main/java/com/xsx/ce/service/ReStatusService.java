package com.xsx.ce.service;

/**
 * @Author： shawn
 * @Description： 推荐状态  获取总体推荐功能是否启用
 * @Date： Create in 17:15 2018/6/15
 * @ModifiedBy:
 */


public interface ReStatusService {

    /**
     * 获取当前推荐状态
     * @return true可用 false不可用
     */
    boolean getReStatus();

}
