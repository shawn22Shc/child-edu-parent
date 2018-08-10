package com.xsx.test;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 9:17 2018/7/17
 * @ModifiedBy:
 */


public class TestExpction {

    public static void main(String[] args) {

        String result = test01(0);
        System.out.println("result :"+result);

    }

    public static String test01(int a){
        try {
            int b = 1/a;
        }catch (Exception e1){
            try {
                int c = 1/0;
            }catch (Exception e2){
                System.out.println(" run e2 ");
                return "e2";
            }
            System.out.println(" run  e1 ");
            return "e1";
        }
        System.out.println(" run success");
        return "success";
    }
}
