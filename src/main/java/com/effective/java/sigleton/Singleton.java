package com.effective.java.sigleton;

import java.io.Serializable;

/**
 * @author horizonliu
 * @date 2019/1/7 10:12 PM
 */
public class Singleton implements Serializable {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        // 防止享有特权的客户端通过反射方法调用私有构造器
        if (INSTANCE != null) {
            throw new UnsupportedOperationException("instance already exist!");
        }
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
