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

    /**
     *    >>按二进制形式把所有的数字向右移动对应位数，低位移出（舍弃），高位的空位补符号位，即正数补零，负数补1。符号位不变。
     *    正数右移高位补0，负数右移高位补1。 1表示负 0表示正
     *
     *    >>>：无符号右移。无论正数还是负数，高位通通补0.
     */


    /**
     * 补码就是负数在计算机中的二进制表示方法。
     * 正数的补码与原码相同 ，所以补码和原码就是正数的二进制表示方法。
     *
     * @param args
     */
    public static void main(String[] args) {
        int a = 0;
        int b = 18;
        int c =2;
        int d =4;

        System.out.println(a + "的二进制表示为：" + Integer.toBinaryString(a));
        System.out.println(b + "的二进制表示为：" + Integer.toBinaryString(b));

        System.out.println(a | b);

        System.out.println(2>>>4);
        System.out.println(2>>4);


        System.out.println(-1>>>1);
        System.out.println(Integer.toBinaryString(-1)); //11111111111111111111111111111111 ，这是-1的二进制表示，高位是1表示负
        //反码是11111111111111111111111111111110
        //源码是01
        System.out.println(Integer.parseInt("01",2));
        System.out.println(Integer.parseInt("00111111111111111111111111111110",2));

        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(-8));


        System.out.println(8>>2);
        System.out.println(-8>>2);

        System.out.println(8>>>2);
        System.out.println(-8>>>2);

    }



}
