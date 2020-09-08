package com.yudianxx.basic.类加载过程;

public class SuperClass {
    static {
        System.out.println("SuperClass 静态代码块!");
    }

    SuperClass(){
        System.out.println("SuperClass 构造函数");
    }

    public static int vaule = 123;
}

class SubClass extends SuperClass {

    public static int vaule = 123456;

    static {
        System.out.println("SubClass 静态代码块!");
    }
    SubClass(){
        System.out.println("SubClass 构造函数");
    }
//执行顺序 静态代码块 要比 构造代码块 快  ，构造代码块 要比 构造函数 快。
    {
        System.out.println("SubClass 构造代码块");
    }
}

class test {
    public static void main(String[] args) {
        SubClass subClassInit = new SubClass(); //一般正常的初始化

        SuperClass[] superClasses = new SuperClass[10]; //通过数组定义引用类，并没有触发SuperClass的初始化阶段
        System.out.println(SuperClass.vaule);

        SubClass[] subClass =new SubClass[1];
        System.out.println(SubClass.vaule);
    }
}

//输出：
//        SuperClass 静态代码块!
//        123
//        SubClass 静态代码块!
//        123456