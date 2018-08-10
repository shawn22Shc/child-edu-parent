package com.xsx.ce.service.impl;

import com.xsx.ce.mapper.ReRoundProportionMapper;
import com.xsx.ce.pojo.ReRoundProportion;
import com.xsx.ce.pojo.ReRoundProportionExample;
import com.xsx.ce.service.ReRoundProportionService;
import com.xsx.ce.util.SerializeUtil;
import com.xsx.ce.util.redis.constant.ConstantForRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 16:55 2018/6/20
 * @ModifiedBy:
 */

@Service
public class ReRoundProportionServiceImpl implements ReRoundProportionService {

    @Autowired
    private ReRoundProportionMapper reRoundProportionMapper;

    @Autowired
    private JedisPool pool;

    @Override
    public ReRoundProportion getRoundProportion(int round) {

        List<ReRoundProportion> list = getReRoundProportionList();
        for (ReRoundProportion prop : list) {
            System.out.println("proportion:"+prop.getStart()+"-"+prop.getEnd()+"-"+prop.getArtificialProportion()
                    +"-"+prop.getSystemProportion());
            // 留左 不留右
            if ( round >= prop.getStart().intValue() && round < prop.getEnd().intValue() ){
                return prop;
            }
            // 最大限制 -1
            if ( round >= prop.getStart().intValue() && prop.getEnd().intValue() == -1 ) {
                return prop;
            }
        }
        return null;
    }

    //---------------------private----------------------------------

    /**
     *  数据库 查找时  需要以 start asc 为主 - -不然。。
     * @return
     */
    private List<ReRoundProportion> getReRoundProportionList(){
        List<ReRoundProportion> list = null;
        Jedis jedis = pool.getResource();
        try{
            String key = ConstantForRedis.RE_ROUND_PROPORTION_LIST;
            if (jedis.exists(key.getBytes())){
                // redis 中有
                list = (List<ReRoundProportion>) SerializeUtil.deserialize( jedis.get(key.getBytes()) );
            }else {
                ReRoundProportionExample example = new ReRoundProportionExample();
                example.createCriteria();
                example.setOrderByClause(" start ASC ");
                list = reRoundProportionMapper.selectByExample(example);
                jedis.set(key.getBytes(),SerializeUtil.serialize(list));
            }
        }finally {
            jedis.close();
        }
        return  list;
    }
}
