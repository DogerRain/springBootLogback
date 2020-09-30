package com.yudianxx.basic.运算符;

/**
 * @author huangyongwen
 * @date 2020/9/29
 * @Description
 */
public class 类型转换 {
    public static void main(String[] args) {
        byte b1 = 1, b2 = 2, b3, b6;
        final byte b4 = 4, b5 = 6;
        b6 = b4 + b5;
//        b3 = (b1 + b2); //所有的byte,short,char型的值将被提升为int型，b1+b2计算后已经是int类型
//        System.out.println(b3 + b6);
    }
}
