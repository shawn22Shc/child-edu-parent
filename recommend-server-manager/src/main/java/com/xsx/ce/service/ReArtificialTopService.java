package com.xsx.ce.service;

import java.util.List;

/**
 * @Author： shawn
 * @Description：  置顶推荐
 *                  目前处理 方式  放在推荐的 前几位
 * @Date： Create in 17:40 2018/6/27
 * @ModifiedBy:
 */


public interface ReArtificialTopService {

    /**
     * 人工置顶推荐
     * @return
     */
    List<Long> getReArtificialTopList();
}
