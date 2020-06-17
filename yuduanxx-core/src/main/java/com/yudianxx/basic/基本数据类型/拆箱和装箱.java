package com.yudianxx.basic.基本数据类型;

public class 拆箱和装箱 {
    public static void main(String[] args) {
        Integer a = 1;
        int b =1;
        Integer c =Integer.valueOf(1);
        Integer d = new Integer(1);

        System.out.println(a==d);
        System.out.println(c==d);


    }
}
