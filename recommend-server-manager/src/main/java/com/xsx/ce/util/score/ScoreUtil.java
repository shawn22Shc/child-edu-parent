package com.xsx.ce.util.score;

/**
 * @Author： shawn
 * @Description： 根据参数获取 分数
 * @Date： Create in 17:14 2018/6/26
 * @ModifiedBy:
 */


public class ScoreUtil {

    // 平均观看 18秒 得一分
    private final static long timePer = 10l;

    //推送 基数  即 10 之后的 未观看 为负数了
    private final static long pushBase = 10l;

    //负数 得分除数       推送10次 0次观看 0分   推送20次 0次观看    （10-20）/5 = -2   最多-5
    private final static long pushPer = 5l;

    public static void main(String[] args) {
       // 56,"sc":0,"ht":5,"ph":11,"tm":110

        long re = getUserTagScore(5l,10l,0l,110);
        System.out.println(re);
    }

    /**
     * 获取 userTag 分数 = =
     * 目前并没有明确的算法  有点蒙= =
     * 等我想通的
     * @param hit
     * @param push
     * @param score
     * @param time  默认最大值是三分钟吧    180/1*18 =
     *              平均 每次 点击 观看时长 超过 3分钟  则打满分 满分为10吧
     * @return
     */
    public static long getUserTagScore(long hit,long push,long score,long time){
        // TODO
        //long result = score + 1l;
        // 如果 hit 数 不小于1
        long scoreExt = 0l;

        // 观看时间小于一秒 相当于没看
        if (time <= 1l){
            hit = 0l;
        }
        if ( hit >= 1l){
            scoreExt = time/(hit*timePer);
            if (push > 0l) {
                if ( hit >= push ){
                    //scoreExt = scoreExt;
                    //不需要做操作
                }else {
                    scoreExt = (scoreExt * hit) / push;
                }
                if (scoreExt >= 10l){
                    scoreExt = 10l;
                }
            }
        }
        // 不能使用 else  上面的 time 如果为0
        if (hit == 0l){
            // hit数为 0 // 怎么分析？？ push?
            push = pushBase - push;
            // 得分
            scoreExt = push/pushPer;
            //
            if (scoreExt < -10l) {
                scoreExt = -10l;
            }
        }
        return scoreExt;
    }

    public static long getLittleTagScore(long hit,long score,long time){
        // TODO
        long result = score + 1l;
        return result;
    }

}
