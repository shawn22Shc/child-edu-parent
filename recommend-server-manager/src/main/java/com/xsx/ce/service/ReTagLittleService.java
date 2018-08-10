package com.xsx.ce.service;

import com.xsx.ce.pojo.ReTagLittle;
import com.xsx.ce.pojo.ext.ReLittleTag;

import java.util.Map;

/**
 * @Author： shawn
 * @Description： 处理  小课与标签关系
 * @Date： Create in 15:01 2018/6/19
 * @ModifiedBy:
 */


public interface ReTagLittleService {

    /**
     *  通过 小课id 获取 与 标签之间的关系
     * @param littleId
     * @return
     */
    Map<Long, ReLittleTag> getReLittleTag(Long littleId);

    /**
     *  通过 json字符串 获取 与 标签之间的关系
     * @param content
     * @return
     */
    Map<Long, ReLittleTag> getReLittleTag(String content);


    /**
     * 一定存在的 tagLittle
     * 前 1-22 不变 后面重新生成
     * 卧槽
     * @param tagLittle
     * @return
     */
    Map<Long, ReLittleTag> getReLittleTag(ReTagLittle tagLittle);

    /**
     * 获取 某课的 标签 （DB）
     * @param littleId
     * @return
     */
    ReTagLittle getReTagLittleByLittleId(Long littleId);

    /**
     * 修改 用户标签
     * @param reTagLittle
     */
    void updateReTagLittle(ReTagLittle reTagLittle);

    /**
     * 修改 用户 标签关系
     * @param littleId
     */
    void updataReTagLittle(Long littleId ,Map<Long,ReLittleTag> map, long time);

    /**
     * 初始化 人与 标签
     * @param littleId
     * @return
     */
    ReTagLittle initReTagLittle(Long littleId);

}
