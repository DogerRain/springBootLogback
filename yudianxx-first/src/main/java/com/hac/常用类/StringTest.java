package com.hac.常用类;

import org.apache.commons.lang3.StringUtils;

/**
 * @author huangyongwen
 * @date 2021/1/21
 * @Description
 */
public class StringTest {
    String WxName = new String("HelloCoder");
    String WxID = "HaC";

    public static void main(String[] args) {
        String WxName = new String("HelloCoder");


        String name1 = new String(new char[]{'H', 'a', 'C'});
        String name2 = "HaC";

    }
}

class Test {
    public static void main(String[] args) {
        String name1 = "HaC";
        String name2 = "HaC";
        String name3 = new String("HaC");
        System.out.println(name1 == name2);
        System.out.println(name1.equals(name2));
        System.out.println(name2 == name3);
        System.out.println(name2.equals(name3));
    }
}

class Test2 {
    public static void main(String[] args) {
        String name = "  \tHelloCoder\r\n".trim(); // "HelloCoder"

        System.out.println(" ".isEmpty());
        System.out.println(StringUtils.isBlank(" "));

        String hello = "HelloCoder,Hello,HaC";
        String[] arr = hello.split(","); //{"HelloCoder","Hello","HaC"}

        System.out.println(String.format("你好呀！%s，今天的心情是%d分", "HaC", 100));


    }
}

class Test3 {
    public static void main(String[] args) {
        String name = "Hello!I am HaC.";
        System.out.println(name.replace("H",""));
        System.out.println(name.replaceFirst("H",""));

    }
}