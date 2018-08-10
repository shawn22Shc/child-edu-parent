package com.xsx.ce.util.score;

import java.util.Objects;

/**
 * @Author： shawn
 * @Description： 为了 treeSet排序 - - 不用redis的  试试
 * @Date： Create in 18:02 2018/6/26
 * @ModifiedBy:
 */


public class ScoreModel implements Comparable<ScoreModel>{

    private long id;

    private double score;

    public ScoreModel(long id, double score) {
        this.id = id;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    @Override
    public int compareTo(ScoreModel model){
        int result = 0;
        double num = score-model.getScore();
        if (num == 0d){
            if(id == model.getId()){
                result = 0;
            }else if (id > model.getId()){
                result = -1;
            }else if (id < model.getId()) {
                result = 1;
            }

        }else if (num > 0d) {
            result = -1;
        }else if (num < 0d) {
            result = 1;
        }
        return result;
    }
}
