package com.xsx.ce.util.redis.constant;

/**
 * @Author： shawn
 * @Description： redis 中使用的常量类
 * @Date： Create in 10:08 2018/6/19
 * @ModifiedBy:
 */


public class ConstantForRedis {

    /**
     *  每个人的 list的key  example:re_luk_
     */
    public static final String RE_LIST_U_KEY = "re_luk_";

    /**
     *  观看 时长 对应 分数 list
     */
    public static final String RE_WATCH_TIME_SCORE_LIST = "re_wts_list";

    /**
     * 轮次 对应 系统 自动推荐 占比 list  即第一轮 应该系统与 人工占比为 1:9
     */
    public static final String RE_ROUND_PROPORTION_LIST = "re_rlp_list";

    /**
     *  推荐 付费 拥有 占比
     */
    public static final String RE_PAY_OWN_PROPORTION = "re_pop";

    /**
     *  课程 拥有标签 缓存
     */
    public static final String RE_LITTLE_TAG_IDS = "re_lti";

    /**
     *  用户 拥有标签 缓存 目前只有年龄
     */
    public static final String RE_USER_TAG_IDS = "re_uti";

    /**
     *  小课 标签map 的json
     */
    public static final String RE_LITTLE_TAG_MAP_STR = "re_ltms";

}
