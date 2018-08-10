package com.xsx.ce.util;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 9:03 2018/8/7
 * @ModifiedBy:
 */


public class MyThread implements Runnable {


    @Override
    public void run() {
        System.out.println("myThread:"+DateUtil.haha());

    }
}
