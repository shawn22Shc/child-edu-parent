package com.xsx.ce.service.impl;

import com.xsx.ce.mapper.ReTimeScoreMapper;
import com.xsx.ce.pojo.ReTimeScore;
import com.xsx.ce.pojo.ReTimeScoreExample;
import com.xsx.ce.service.ReTimeScoreService;
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
 * @Date： Create in 15:11 2018/6/19
 * @ModifiedBy:
 */

@Service
public class ReTimeScoreServiceImpl implements ReTimeScoreService {

    @Autowired
    private ReTimeScoreMapper reTimeScoreMapper;

    @Autowired
    private JedisPool pool;

    @Override
    public long getScore(int time) {
        long score = 0l;
        List<ReTimeScore> list = getReTimeScoreList();
        for (ReTimeScore reTimeScore : list) {
            if (reTimeScore == null) {
                continue;
            }
            System.out.println( reTimeScore.getStart()+"-"+reTimeScore.getEnd()+"-"+reTimeScore.getScore() );
            //留左  不留右
            if (time >= reTimeScore.getStart().intValue()  &&  time < reTimeScore.getEnd().intValue()){
                score = reTimeScore.getScore();
                break;
            }
            //最后
            if (time >= reTimeScore.getStart().intValue()  &&  reTimeScore.getEnd().intValue() == -1 ){
                score = reTimeScore.getScore();
                break;
            }
        }
        return score;
    }

    //-------------------------private------------------------------------

    /**
     * 获取 时间分数 list  按照 start ASC 排序 不然。。
     * @return
     */
    private List<ReTimeScore> getReTimeScoreList(){
        List<ReTimeScore> list = null;
        Jedis jedis = pool.getResource();
        try{
            String key = ConstantForRedis.RE_WATCH_TIME_SCORE_LIST;

            if (jedis.exists(key.getBytes())){
                //存在
                //System.out.println(" 存在 ");
                list = (List<ReTimeScore>) SerializeUtil.deserialize(jedis.get(key.getBytes()));
            }else {
                //不存在
                //System.out.println(" 不存在 ");
                ReTimeScoreExample example = new ReTimeScoreExample();
                example.createCriteria();
                example.setOrderByClause(" start ASC ");
                list = reTimeScoreMapper.selectByExample(example);
                jedis.set(key.getBytes(),SerializeUtil.serialize(list));
            }

        }finally {
            jedis.close();
        }
        return list;
    }

}
