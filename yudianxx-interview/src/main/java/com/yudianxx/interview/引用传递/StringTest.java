package com.yudianxx.interview.引用传递;

public class StringTest {
    public static void main(String[] args) {
        // 在编译阶段JVM先去常量池中查找是否存在“abc”，如果过不存在，则在常量池中开辟一个空间存储“abc”。
        // 在运行时期，通过String类的构造器在堆内存中new了一个空间，然后将String池中的“abc”复制一份存放到该堆空间中，
        // 在栈中开辟名字为str2的空间，存放堆中new出来的这个String对象的地址值。
        String s1 = new String("xyz");
        String s2 = new String("xyz");
        String s3 = "xyz";
        String s4 = "xyz";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

        String str = "hello";
        System.out.println(str.hashCode());
        String str1 = str + "world";
        str = str + "world";
        String str2 ="helloworld";
        //常量池 helloworld 的hash值，一样
        System.out.println(str.hashCode());
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
}
