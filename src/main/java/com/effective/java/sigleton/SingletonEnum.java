package com.effective.java.sigleton;


/**
 * 使用枚举类实现 单元素的 单例类
 * @author horizonliu
 * @date 2019/1/8 1:22 PM
 */

public enum SingletonEnum {
    /**
     * 实例
     */
    INSTANCE;

    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
