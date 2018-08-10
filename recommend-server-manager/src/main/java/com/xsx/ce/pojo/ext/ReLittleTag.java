package com.xsx.ce.pojo.ext;

/**
 * @Author： shawn
 * @Description： 用小课 标签打分类
 *                  tg 标签id  sc 分数 ht点击次数 tm 时长
 * @Date： Create in 13:39 2018/6/25
 * @ModifiedBy:
 */


public class ReLittleTag {

    private long tg;

    private long sc;

    private long ht;

    private long tm;

    public long getTg() {
        return tg;
    }

    public void setTg(long tg) {
        this.tg = tg;
    }

    public long getSc() {
        return sc;
    }

    public void setSc(long sc) {
        this.sc = sc;
    }

    public long getHt() {
        return ht;
    }

    public void setHt(long ht) {
        this.ht = ht;
    }

    public long getTm() {
        return tm;
    }

    public void setTm(long tm) {
        this.tm = tm;
    }
}
