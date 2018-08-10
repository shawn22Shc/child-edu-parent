package com.xsx.ce.pojo.ext;

import java.io.Serializable;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 15:54 2018/6/20
 * @ModifiedBy:
 */


public class RePayOwnProp implements Serializable{

    private static final long serialVersionUID = -3711380476344243501L;

    private int pay;

    private int own;

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getOwn() {
        return own;
    }

    public void setOwn(int own) {
        this.own = own;
    }
}
