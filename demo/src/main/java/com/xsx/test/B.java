package com.xsx.test;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 15:19 2018/7/26
 * @ModifiedBy:
 */


public class B extends A {

    static {
        System.out.println(" B static ");
    }

    {
        System.out.println(" B static  1");
    }

    public B(int a){
        super(a);
        System.out.println(" B p");
    }
}
