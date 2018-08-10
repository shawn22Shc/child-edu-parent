package com.xsx.ce.service;

import com.xsx.ce.pojo.ReRoundProportion;
import com.xsx.ce.pojo.ext.RePayOwnProp;
import com.xsx.ce.pojo.ext.ReScoreExpandProp;

/**
 * @Author： shawn
 * @Description：  参数 service 比如 付费 非付费占比，
 *                  比如 观看时间 对应的分数  比如 轮次 对应的 系统 - 人工推荐占比
 * @Date： Create in 14:24 2018/6/20
 * @ModifiedBy:
 */


public interface ReParameterService {

    /**
     * 通过观看时长 看到分数
     * @param time
     * @return
     */
    long getScoreByTime(int time);

    /**
     * 获取 付费与 拥有推荐占比
     * @return
     */
    RePayOwnProp getPayOwnProportion();

    /**
     *  根据轮次 找到对应的占比
     * @param round
     * @return
     */
    ReRoundProportion getReRoundProportionByRound(int round);

    /**
     * 获取 分数 拓展 比例
     * @return
     */
    ReScoreExpandProp getReScoreExpandProp();


    /**
     * 获取 最大生成时间间隔
     * @return
     */
    long getMaxReListProduceTime();

    /**
     * 获取  每次生成的推荐列表长度
     * @return
     */
    int getReListSize();


}
