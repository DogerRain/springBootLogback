package com.hac.静态;

/**
 * @author huangyongwen
 * @date 2021/1/14
 * @Description
 */
public class HelloCoder {
    static String name = "HaC"; //静态变量

    static   //静态代码块
    {
        System.out.println(name);
    }

    //静态方法
    public static void printName() {

        System.out.println(name);
//        test(); //报错，静态方法不能调用非静态方法
    }

    public void test() { //平台方法
        printName();    //非静态方法可以调用静态方法
//        static int age = 1;    //报错，static是不允许用来修饰局部变量
    }

    public static void main(String[] args) {    //main方法也是一个静态方法
        HelloCoder helloCoder = new HelloCoder();
        helloCoder.printName(); //也可以使用对象访问静态方法

        HelloCoder.printName(); //建议使用这种方法访问
    }
}