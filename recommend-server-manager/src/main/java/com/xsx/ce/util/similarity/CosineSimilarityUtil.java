package com.xsx.ce.util.similarity;

import com.xsx.ce.pojo.ext.ReLittleTag;
import com.xsx.ce.pojo.ext.ReUserTag;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 15:36 2018/6/26
 * @ModifiedBy:
 */


public class CosineSimilarityUtil {

    public static void main(String[] args) {
        //-------------------little---------------------------
        Map<Long, ReLittleTag> littleTagMap = new HashMap<>();
        ReLittleTag littleTag1 = new ReLittleTag();
        littleTag1.setSc(10l);
        ReLittleTag littleTag2 = new ReLittleTag();
        littleTag2.setSc(10l);
        littleTagMap.put(90l,littleTag1);
        littleTagMap.put(99l,littleTag2);
        //---------------------user----------------
        Map<Long,ReUserTag> userTagMap = new HashMap<>();
        ReUserTag userTag1 = new ReUserTag();
        userTag1.setSc(1l);
        ReUserTag userTag2 = new ReUserTag();
        userTag2.setSc(1l);
        userTagMap.put(1l,userTag1);
        userTagMap.put(2l,userTag2);
        double result = getUserLittleTagCosSimilarity(littleTagMap,userTagMap);

        System.out.println( "result:"+result);
    }

    /**
     * 获取 课程与 人 之间的 余弦相似度
     * @param littleTagMap
     * @param userTagMap
     * @return
     */
    public static double getUserLittleTagCosSimilarity(Map<Long, ReLittleTag> littleTagMap,
                                                       Map<Long,ReUserTag> userTagMap){
        Map<Long, long[]> paramMap = new HashMap<>();
        for (Long littleTagId : littleTagMap.keySet()) {
            if ( littleTagId.longValue() <= 22l ){
                continue;
            }
            if (paramMap.containsKey(littleTagId)) {
                // 课程 标签默认为 sc 为1 吧
                paramMap.get(littleTagId)[0] += littleTagMap.get(littleTagId).getSc();
            } else {
                long[] tempArray = new long[2];
                tempArray[0] = littleTagMap.get(littleTagId).getSc();
                tempArray[1] = 0l;
                paramMap.put(littleTagId, tempArray);
            }
        }
        for (Long userTagId : userTagMap.keySet()) {
            if ( userTagId.longValue() <= 22l ){
                continue;
            }
            if (paramMap.containsKey(userTagId)) {
                paramMap.get(userTagId)[1] += userTagMap.get(userTagId).getSc();
            } else {
                long[] tempArray = new long[2];
                tempArray[0] = 0l;
                tempArray[1] = userTagMap.get(userTagId).getSc();
                paramMap.put(userTagId, tempArray);
            }
        }
        int a = paramMap.keySet().size();
        System.out.println(" size :"+a);
        /*for (Long id : paramMap.keySet()) {
            System.out.println( paramMap.get(id)[0]+"----"+paramMap.get(id)[1] );
        }*/
        return sim(paramMap);

    }


    // 求余弦相似度
    private static double sim(Map<Long, long[]> paramMap) {
        double result = 0;
        result = pointMulti(paramMap) / sqrtMulti(paramMap);
        return result;
    }

    private static double sqrtMulti(Map<Long, long[]> paramMap) {
        double result = 0;
        result = squares(paramMap);
        result = Math.sqrt(result);
        return result;
    }

    // 求平方和
    private static double squares(Map<Long, long[]> paramMap) {
        double result1 = 0;
        double result2 = 0;
        Set<Long> keySet = paramMap.keySet();
        for (Long character : keySet) {
            long temp[] = paramMap.get(character);
            result1 += (temp[0] * temp[0]);
            result2 += (temp[1] * temp[1]);
        }
        return result1 * result2;
    }

    // 点乘法
    private static double pointMulti(Map<Long, long[]> paramMap) {
        double result = 0;
        Set<Long> keySet = paramMap.keySet();
        for (Long character : keySet) {
            long temp[] = paramMap.get(character);
            result += (temp[0] * temp[1]);
        }
        return result;
    }



}
