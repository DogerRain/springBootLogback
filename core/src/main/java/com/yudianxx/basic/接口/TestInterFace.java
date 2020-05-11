package com.yudianxx.basic.接口;

public interface TestInterFace extends Runnable{
    int a =1;

    void A();

    public static void testInterface(){
        System.out.println("JDK1.8可以使用static修饰接口方法");

    }
//    Interface abstract methods cannot have body
//    public void test(){
//
//    }
    //接口.方法名可以调用方法
    public static void test(){
        TestInterFace.testInterface();
    }
}
