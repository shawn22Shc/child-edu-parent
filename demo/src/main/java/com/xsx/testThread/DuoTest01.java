package com.xsx.testThread;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 9:48 2018/7/17
 * @ModifiedBy:
 */


public class DuoTest01 implements Runnable{

    private int count;


    @Override
    public void run() {
        //this.notify();

        for (int i = 0; i <5; i++) {
            count++;
            System.out.println("count:"+count);
        }
    }
}
