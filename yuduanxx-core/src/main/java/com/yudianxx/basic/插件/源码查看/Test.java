package com.yudianxx.basic.插件.源码查看;

/**
 * @author HaC
 * @date 2020/10/14
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        String a = "I am ";
        String b = "HaC";
        String c = a + b;
        String d = "I am " + "HaC";
        System.out.println(c == d); //false
        Integer i =1000; //装箱
        int j = i;  //拆箱
        System.out.println(i == j); //true

    }
}
