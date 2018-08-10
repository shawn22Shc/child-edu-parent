package com.xsx.ce.service;

import java.util.List;

/**
 * @Author： shawn
 * @Description： 人工推荐  类似 1,2,3,4,5 岁 推荐 哪个课 男孩推荐哪个课
 * @Date： Create in 17:54 2018/6/27
 * @ModifiedBy:
 */


public interface ReArtificialCourseService {

    /**
     * 根据 年龄 性别 获取 人工推荐
     * @param age
     * @param gender
     * @param size  要多少条 感觉有点毛病。
     * @return
     */
    List<Long> getReArtificialCourseList(int size, int age,int gender);
}
