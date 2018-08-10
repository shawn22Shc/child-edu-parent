package com.xsx.ce.service.impl;

import com.xsx.ce.mapper.ReParameterMapper;
import com.xsx.ce.pojo.ReParameter;
import com.xsx.ce.pojo.ReRoundProportion;
import com.xsx.ce.pojo.ext.RePayOwnProp;
import com.xsx.ce.pojo.ext.ReScoreExpandProp;
import com.xsx.ce.service.ReParameterService;
import com.xsx.ce.service.ReRoundProportionService;
import com.xsx.ce.service.ReTimeScoreService;
import com.xsx.ce.util.SerializeUtil;
import com.xsx.ce.util.enums.ParameterEnum;
import com.xsx.ce.util.redis.constant.ConstantForRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author： shawn
 * @Description： 参数 service 比如 付费 非付费占比，
 *                  比如 观看时间 对应的分数  比如 轮次 对应的 系统 - 人工推荐占比
 * @Date： Create in 14:26 2018/6/20
 * @ModifiedBy:
 */

@Service
public class ReParameterServiceImpl implements ReParameterService {

    @Autowired
    private ReTimeScoreService reTimeScoreService;

    @Autowired
    private ReParameterMapper reParameterMapper;

    @Autowired
    private ReRoundProportionService reRoundProportionService;

    @Autowired
    private JedisPool pool;

    @Override
    public long getScoreByTime(int time) {
        return reTimeScoreService.getScore(time);
    }

    /**
     * 获取 付费与 拥有推荐占比
     * @return
     */
    @Override
    public RePayOwnProp getPayOwnProportion() {
        RePayOwnProp prop = new RePayOwnProp();
        Jedis jedis = pool.getResource();
        try{
            String key = ConstantForRedis.RE_PAY_OWN_PROPORTION;
            if( jedis.exists(key.getBytes()) ){
                // 存在 redis
                prop = (RePayOwnProp)SerializeUtil.deserialize(jedis.get(key.getBytes()));
            } else {
                //不存在 redis
                int pay = getPayProportion();
                int own = getOwnProportion();
                prop.setPay(pay);
                prop.setOwn(own);
                jedis.set(key.getBytes(),SerializeUtil.serialize(prop));
            }
        }finally {
            jedis.close();
        }
        return prop;
    }

    @Override
    public ReRoundProportion getReRoundProportionByRound(int round) {
        if (round < 0){
            return null;
        }
        ReRoundProportion result = reRoundProportionService.getRoundProportion(round);
        if (result == null){
            System.out.println("---------------- w0cao  ReRoundProportion =  null ---------------------");
            result = new ReRoundProportion();
            result.setArtificialProportion(50);
            result.setSystemProportion(50);
        }
        return result;
    }

    @Override
    public ReScoreExpandProp getReScoreExpandProp() {
        int score = getScoreProporation();
        int expand = getPayProportion();
        ReScoreExpandProp result = new ReScoreExpandProp();
        result.setScore(score);
        result.setExpand(expand);
        return result;
    }

    @Override
    public long getMaxReListProduceTime() {
        ReParameter parameter = getReParameterByEnum(ParameterEnum.user_check_max_time);
        if(parameter != null ){
            if (parameter.getLongValue() != null){
                return parameter.getLongValue();
            }
        }
        //默认两天吧
        return 172800000l;
    }

    @Override
    public int getReListSize() {
        ReParameter parameter = getReParameterByEnum(ParameterEnum.re_list_size);
        if(parameter != null ){
            if (parameter.getIntValue() != null && parameter.getIntValue() > 0){
                return parameter.getIntValue();
            }
        }
        //默认100吧
        return 100;
    }


    //-----------------------------private----------------------------

    /**
     * 获取 扩展占比
     * @return
     */
    private int getExpandProporation(){
        int result = 20;
        ReParameter param = getReParameterByEnum(ParameterEnum.expand_proporation);
        if (param != null){
            if (param.getIntValue() != null && param.getIntValue() > 0){
                result = param.getIntValue();
            }
        }
        return result;
    }

    /**
     * 获取 score 占比
     * @return
     */
    private int getScoreProporation(){
        int result = 80;
        ReParameter param = getReParameterByEnum(ParameterEnum.score_proporation);
        if (param != null){
            if (param.getIntValue() != null && param.getIntValue() > 0){
                result = param.getIntValue();
            }
        }
        return result;
    }

    /**
     * 获取 own 占比
     * @return
     */
    private int getOwnProportion(){
        int result = 80;
        ReParameter param = getReParameterByEnum(ParameterEnum.own_proporation);
        if (param != null){
            if (param.getIntValue() != null && param.getIntValue() > 0){
                result = param.getIntValue();
            }
        }
        return result;
    }

    /**
     * 获取 pay 占比
     * @return
     */
    private int getPayProportion(){
        int result = 20;
        ReParameter param = getReParameterByEnum(ParameterEnum.pay_proporation);
        if (param != null){
            if (param.getIntValue() != null && param.getIntValue() > 0){
                result = param.getIntValue();
            }
        }
        return result;
    }

    /**
     * 根据 Enum 获取参数
     * @param key
     * @return
     */
    private ReParameter getReParameterByEnum(ParameterEnum key){
        return getReParameterByKey(key.toString());
    }

    /**
     * 根据字符串 获取参数
     * @param key
     * @return
     */
    private ReParameter getReParameterByKey(String key){
        return reParameterMapper.selectByPrimaryKey(key);
    }


}
