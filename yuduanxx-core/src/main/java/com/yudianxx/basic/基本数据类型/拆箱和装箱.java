package com.yudianxx.basic.基本数据类型;

public class 拆箱和装箱 {
    public static void main(String[] args) {
        Integer a = 1;
        int b = 1;
        Integer c = Integer.valueOf(1);
        Integer d = new Integer(1);

        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(c == d);

        //拆箱 Integer 转 int
        //装箱 int 转 Integer

        String[] str = new String[2];

        Object[] str1 = str;

        str[0] = "abc";

         int a1  =  Integer.valueOf("123");

         int a2 =  Integer.valueOf(1);

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }


    }
}
