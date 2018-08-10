package com.xsx.ce.util;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 16:06 2018/6/11
 * @ModifiedBy:
 */


public class BloomFilterUtils {

    private static int size = 10000;

    private static double fpp = 0.03d;

    public static BloomFilter<Long> getLongBloomFilter(){
        return BloomFilter.create(Funnels.longFunnel(),size,fpp);
    }

    public static BloomFilter<Integer> getIntegerBloomFilter(){
        return BloomFilter.create(Funnels.integerFunnel(),size,fpp);
    }

    public static BloomFilter<String> getStringBloomFilter(){
        return BloomFilter.create(Funnels.stringFunnel(Charset.forName("Utf-8")),size,fpp);
    }


    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = getStringBloomFilter();

        for (long i = 0; i < 1000; i++) {
            bloomFilter.put(String.valueOf(i*2));
        }

        for (long i = 0; i < 1000; i++) {
            if (!bloomFilter.mightContain(String.valueOf(i*2))) {
                System.out.println("有坏人逃脱了");
            }
        }

        System.out.println("20"+bloomFilter.mightContain("20"));
        System.out.println("1000200"+bloomFilter.mightContain("1000200"));

        List<Long> list = new ArrayList<Long>();
        for (long i = size + 2000; i < size + 8000; i++) {
            if (bloomFilter.mightContain(String.valueOf(i*2))) {
                list.add(i);
            }
        }

        System.out.println("有误伤的数量：" + list.size());
    }

}
