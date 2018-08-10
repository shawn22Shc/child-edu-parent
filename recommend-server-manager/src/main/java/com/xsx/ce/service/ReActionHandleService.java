package com.xsx.ce.service;

/**
 * @Author： shawn
 * @Description： 行为收集  user-tag    little-tag
 * @Date： Create in 13:32 2018/6/22
 * @ModifiedBy:
 */


public interface ReActionHandleService {

    /**
     * 处理 用户 与 tag
     * @return 返回值为 抛出异常个数
     */
    int handleUserTag();

    /**
     * 处理 小课 与 tag
     *  目前 只能处理 tag 1-22
     *  原因: 以用户行为 给课程打标签 只有 年龄 与 性别有用吧 因为 用户的其他标签 有什么用呢？？
     *  例子  用户有汽车标签   这个课程是 水果，难道 把汽车打过来？  还是标签系统不够完善。。
     * @return
     */
    int handleLittleTag();

}
