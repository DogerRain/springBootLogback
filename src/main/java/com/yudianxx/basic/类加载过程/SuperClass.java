package com.yudianxx.basic.类加载过程;

public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int vaule = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}

class test {
    public static void main(String[] args) {
        SubClass subClass = new SubClass(); //一般正常的初始化
//        SuperClass superClasses = new SuperClass(); //一般正常的初始化
//        SuperClass[] superClasses = new SuperClass[10]; //通过数组定义引用类，并没有触发SuperClass的初始化阶段

//        System.out.println(SubClass.vaule);
    }
}

//输出：
//        SuperClass init!
//        123