package com.xsx.ce.util.score;

import com.xsx.ce.pojo.ext.RePayOwnProp;
import com.xsx.ce.util.SerializeUtil;
import org.apache.commons.lang3.SerializationUtils;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 18:11 2018/6/26
 * @ModifiedBy:
 */


public class Test {




    public static void main(String[] args) {
        RePayOwnProp a = new RePayOwnProp();
        a.setOwn(1);
        a.setPay(2);

        byte[] c = SerializationUtils.serialize(a);
        byte[] d = SerializeUtil.serialize(a);
        for (byte e:
             c) {
            System.out.print(e);
        }
        System.out.println();
        for (byte e:
                d) {
            System.out.print(e);
        }




        /*Random random = new Random();

        Set<ScoreModel> set = new TreeSet<>();
        for (long i = 1l; i <= 1000l ; i++) {
            int score = random.nextInt();
            System.out.println("score:"+score);
            ScoreModel a = new ScoreModel(i,score);
            set.add(a);
        }

        for (ScoreModel sc:set ) {
            System.out.println( "id:"+sc.getId()+" sc:"+sc.getScore());
        }*/
    }

}
