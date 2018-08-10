package com.xsx.ce.util;

import com.xsx.ce.util.score.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 17:52 2018/8/6
 * @ModifiedBy:
 */


public class DateUtil {

    private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>();

    public static Date parse(String str) throws Exception {
        SimpleDateFormat sdf = local.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
            local.set(sdf);
        }
        return sdf.parse(str);
    }

    public static String format(Date date) throws Exception {
        SimpleDateFormat sdf = local.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
            local.set(sdf);
        }
        System.out.println("sdf:"+sdf);
        return sdf.format(date);
    }



    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            System.out.println("======================================init   run");
            DateFormat a = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat b = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("-----------------------------------------a:"+a);
            System.out.println("-----------------------------------------b:"+b);

            return a;
        }
    };

    private static final ThreadLocal<Test001> tst = new ThreadLocal<Test001>(){
        @Override
        protected Test001 initialValue() {

            Test001 c = new Test001();
            System.out.println("-------------------c:"+c);
            return c;
        }
    };

    public static Test001 haha(){
        return tst.get();
    }

    public static String getDate(Date date){
        DateFormat dfs = df.get();
        System.out.println("object:"+dfs);
        String a = dfs.format(date);
        return a;
    }

}
