package com.effective.java;


import lombok.*;

/**
 * effective java - builder 模式
 * @author horizonliu
 * @date 2018/12/26 8:53 PM
 */

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@ToString
//@Builder
public class OuterClass {
    private String param1;
    private String param2;
    private String param3;
    private String param4;

    public OuterClass(Builder builder) {
        this.param1 = builder.param1;
        this.param2 = builder.param2;
        this.param3 = builder.param3;
        this.param4 = builder.param4;
    }

    public static class Builder {
        private String param1;
        private String param2;
        private String param3;
        private String param4;

        public Builder() {}

        // 还可以有其他构造函数
        public Builder(String param1, String param2) {
            this.param1 = param1;
            this.param2 = param2;
            // 对其他参数设默认值
            this.param3 = "xixi";
            this.param4 = "haha";
        }

        public Builder param1(String param1) {
            this.param1 = param1;
            return this;
        }

        public Builder param2(String param2) {
            this.param2 = param2;
            return this;
        }

        public Builder param3(String param3) {
            this.param3 = param3;
            return this;
        }

        public Builder param4(String param4) {
            this.param4 = param4;
            return this;
        }

        public OuterClass build() {
            return new OuterClass(this);
        }
    }

    // 调用一下OuterClass
    public static void main(String[] args) {
        OuterClass bean = new OuterClass.Builder().param1("xixi")
                .param2("haha")
                .param3("xxxxx")
                .param4("hhhhhhh")
                .build();

        System.out.println(bean.toString());

        OuterClass bean2 = new OuterClass.Builder("xixi", "haha")
                .param3("xxxxxxxxxxxx")
                .build();
        System.out.println(bean2.toString());

        // 使用@Builder注解时的用法
//        OuterClass bean = OuterClass.builder()
//                .param1("xixi")
//                .param2("haha")
//                .param3("xxxxxxxx")
//                .build();
//
//        // 输出：OuterClass(param1=xixi, param2=haha, param3=xxxxxxxx, param4=null)
//        System.out.println(bean);
    }
}
