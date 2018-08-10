package com.xsx.ce.pojo.ext;

import java.io.Serializable;

/**
 * @Author： shawn
 * @Description： 分数推荐 与兴趣拓展 占比
 * @Date： Create in 14:17 2018/6/28
 * @ModifiedBy:
 */


public class ReScoreExpandProp implements Serializable{

    private static final long serialVersionUID = -5774505137929333180L;

    private int score;  //分数

    private int expand; // 扩展

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getExpand() {
        return expand;
    }

    public void setExpand(int expand) {
        this.expand = expand;
    }
}
