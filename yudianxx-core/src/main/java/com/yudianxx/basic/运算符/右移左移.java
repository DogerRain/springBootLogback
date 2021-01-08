package com.yudianxx.basic.运算符;

/**
 * @author huangyongwen
 * @date 2020/7/1
 * @Description
 */
public class 右移左移 {
    public static void main(String[] args) {
//        1. 无符号 右移 多少位    变小
        int n = 128 >>> 3; //右移两位 128 / 2^3
//        有符号 右移
        int m = -4 >> 2;

        int x = -4 >>> 2;

        System.out.println(n);
        System.out.println(m);
        System.out.println(x);

        //        1.  左移 变大  注意，左移是不能带符号的，没有<<< 因为左边最高位就是符号位
        int n1 = 3 << 3;  //  3* 2^3  = 24
        int m1 = -4 << 2;

        System.out.println(n1);
        System.out.println(m1);

        System.out.println(8&1);

    }
}
