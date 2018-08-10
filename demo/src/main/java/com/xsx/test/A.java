package com.xsx.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 15:18 2018/7/26
 * @ModifiedBy:
 */


public class A {



    static {
        System.out.println(" A static ");
    }

    {
        System.out.println(" A static  1");
    }

    public A(int a){
        System.out.println(" A P ");
    }

    public void a(){
        int n =10;
        int result = 0;
        int n1 = 1;
        int n2 = 1;
        for ( int i = 3;i<=n;i++){
            result = n1+n2;
            n2 = n1;
            n1 = result;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        b();
    }


    public static void b(){
        String[] a = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int count = 26;
        int flag = 1;
        while (count > 1){
            for (int i = 0; i < a.length;i++) {
                //System.out.println("  "+a[i]+" flag: "+flag +" count: "+count);
                if (!a[i].equals("")){
                    if (flag == 5){
                        a[i] = "";
                        flag = 0;
                        count--;
                    }
                    flag++;
                }
            }
        }
        for (int i = 0; i < a.length;i++) {
            if (!a[i].equals("")){
                System.out.println("result :"+a[i]);
            }
        }

    }

    public static void c(){
        Set<String> a  = new HashSet<String>();
        String[] b = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for (String c :b){
            a.add(c);
        }

        Iterator e =  a.iterator();



    }

}
