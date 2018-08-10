package com.xsx.ce.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author： shawn
 * @Description： 序列化 与 反序列化
 * @Date： Create in 15:30 2018/6/19
 * @ModifiedBy:
 */


public class SerializeUtil {


    /**
     * 序列化 对象
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     */
    public static Object deserialize (byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
