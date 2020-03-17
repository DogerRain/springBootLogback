package com.yudianxx.basic.运算符;

/**
 * @author huangyongwen
 * @date 2020/1/7
 * @Description
 */
public class BasicOperator {
    //    位运算符
//
//|按位或和&按位与计算方式都是转换二进制再计算，不同的是运算规则(一个为真即为真)1|0 = 1 , 1|1 = 1 , 0|0 = 0 , 0|1 = 1
//
//6的二进制位0000 0110 , 2的二进制位0000 0010 , 110|010为110，最终值0000 0110，故6|2等于6
    public static void main(String[] args) {
        int a = 0;
        int b = 18;

        System.out.println(a + "的二进制表示为：" + Integer.toBinaryString(a));
        System.out.println(b + "的二进制表示为：" + Integer.toBinaryString(b));

        System.out.println(a | b);
    }

}
