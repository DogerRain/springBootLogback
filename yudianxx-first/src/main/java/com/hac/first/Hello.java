package com.hac.first;

public class Hello {
    static int age; //全局变量、类变量
    private static String name ; //静态变量，没有初始化值
    static final String WEIXIN_ID = "HelloCoder";

    public static void main(String[] args) {
        String name = "HaC";
        Hello.printName();  //static 的方法可以直接使用 类名.方法名 调用
        printSex(); // 同一个类的static方法 则 可以直接调用
//        WEIXIN_ID = "HelloCoder200";
    }

    private static void printName() {  //方法
        System.out.println(name);  //static方法调用的方法、变量必须也是static的
        System.out.println(age);  //static方法调用的方法、变量必须也是static的
    }

    private static void printSex() {
        String sex = "男";
        System.out.println(sex); //局部变量sex要想使用，必须初始化
    }
}