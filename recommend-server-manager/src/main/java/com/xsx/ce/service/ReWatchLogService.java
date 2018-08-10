package com.xsx.ce.service;

import com.xsx.ce.pojo.ReWatchLog;

import java.util.List;

/**
 * @Author： shawn
 * @Description： 观看历史
 * @Date： Create in 15:08 2018/6/19
 * @ModifiedBy:
 */


public interface ReWatchLogService {

    /**
     * 获取 某小课的 观看 历史记录
     * @param littleId
     * @param time
     * @return
     */
    int getLittleWatchLogCount(Long littleId ,Long time);


    /**
     * 获取 某人 某段时间 之后的 历史记录数
     * @param userId
     * @param time
     * @return
     */
    int getUserWatchLogCount(Long userId, Long time );

    /**
     * 获取 time时间 之后 某用户的 分页观看历史
     * @param pageNum
     * @param pageSize
     * @param userId
     * @param time
     * @return
     */
    List<ReWatchLog> getUserWatchlog(int pageNum,int pageSize,Long userId,Long time);

    /**
     *  获取 time 时间 之后  某视频的  分页观看历史
     * @param pageNum
     * @param pageSize
     * @param videoId
     * @param time
     * @return
     */
    List<ReWatchLog> getVideoWatchlog(int pageNum,int pageSize,Long videoId,Long time);
}
