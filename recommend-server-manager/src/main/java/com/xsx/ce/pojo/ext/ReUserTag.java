package com.xsx.ce.pojo.ext;

/**
 * @Author： shawn
 * @Description： 用户的 标签打分类
 *                  tg 标签id  sc 分数 ph推送次数 ht点击次数 tm 时长
 * @Date： Create in 19:05 2018/6/20
 * @ModifiedBy:
 */


public class ReUserTag {

    private long tg;

    private long sc;

    private long ht;

    private long ph;

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

    public long getPh() {
        return ph;
    }

    public void setPh(long ph) {
        this.ph = ph;
    }

    public long getTm() {
        return tm;
    }

    public void setTm(long tm) {
        this.tm = tm;
    }
}
