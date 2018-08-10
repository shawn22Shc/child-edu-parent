package com.xsx.ce.service;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 15:10 2018/6/19
 * @ModifiedBy:
 */


public interface ReTimeScoreService {

    /**
     * 根据观看时长 得到分数
     * @param time
     * @return
     */
    long getScore(int time);
}
