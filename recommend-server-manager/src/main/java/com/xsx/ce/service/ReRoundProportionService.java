package com.xsx.ce.service;

import com.xsx.ce.pojo.ReRoundProportion;

/**
 * @Author： shawn
 * @Description： 不同轮次 对应 的 系统 / 人工 推荐占比
 * @Date： Create in 16:51 2018/6/20
 * @ModifiedBy:
 */


public interface ReRoundProportionService {

    /**
     * 通过 轮次 获取 占比
     * @param round
     * @return
     */
    ReRoundProportion getRoundProportion(int round );

}
