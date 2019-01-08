package com.effective.java.sigleton;

import java.io.*;

/**
 * @author horizonliu
 * @date 2019/1/8 11:38 AM
 */
public class SerializableTest {

    public static void main(String[] args) throws Exception{
        // 序列化对象
        serializable(Singleton.getInstance(), "test");

        // 反序列化对象
        Singleton singleton = deserializable("test");

        // 检查序列化前后两个实例是否一样
        if (singleton != Singleton.getInstance()) {
            System.out.println("singleton: " + singleton.toString() + "\nSingleton.getInstance: " + Singleton.getInstance());
            System.out.println("two instances are different\n");
        } else {
            System.out.println("two instances are the same\n");
        }

        // 使用枚举类单例
        SingletonEnum.INSTANCE.setField("123");
        System.out.println(SingletonEnum.INSTANCE.getField());
    }

    /**
     * 序列化
     */
    private static void serializable(Singleton singleton, String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(singleton);
        oos.flush();
    }
    /**
     * 反序列化
     */
    @SuppressWarnings("unchecked")
    private static  <T> T deserializable(String filename) throws IOException,ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (T) ois.readObject();
    }
}
