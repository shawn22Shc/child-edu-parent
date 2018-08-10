package com.xsx.ce.service;

/**
 * @Author： shawn
 * @Description： 生成 每个人的 推荐列表；
 * @Date： Create in 9:34 2018/6/26
 * @ModifiedBy:
 */


public interface ReProduceService {

    /**
     * 生成 每个人的 推荐列表
     * 需要在每天的推荐 行为处理完 之后再运行
     * @return
     */
    int produceUserReList();

}
