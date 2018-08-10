package com.xsx.ce.service;

import com.xsx.ce.pojo.ReTagUser;
import com.xsx.ce.pojo.ext.ReUserTag;

import java.util.Map;

/**
 * @Author： shawn
 * @Description： user 与 tag的关系
 * @Date： Create in 9:26 2018/6/21
 * @ModifiedBy:
 */


public interface ReUserTagService {

    /**
     *  获取 用户 目前 与标签的关系
     * @param userId
     * @return
     */
    Map<Long,ReUserTag> getReUserTag(Long userId);

    /**
     * 通过 content 获取  标签的关系
     * @param content
     * @return
     */
    Map<Long,ReUserTag> getReUserTagMap(String content);

    /**
     * 获取 某人的 标签 （DB）
     * @param userId
     * @return
     */
    ReTagUser getReTagUserByUserId(Long userId);

    /**
     * 修改 用户标签
     * @param reTagUser
     */
    void updateReTagUser(ReTagUser reTagUser);

    /**
     * 修改 用户 标签关系
     * @param userId
     */
    void updataReTagUser(Long userId ,Map<Long,ReUserTag> map, long time);

    /**
     * 初始化 人与 标签
     * @param userId
     * @return
     */
    ReTagUser initReTagUser(Long userId);
}
