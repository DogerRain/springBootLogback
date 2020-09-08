package com.yudianxx.basic.接口;

//这里不是 implement 而是extends
public interface TestInterFace2 extends Runnable {
    int num=1;
    int a = 1;
    public static int b = 2;
    public static final int c = 2;
    final static int ans =1;




    abstract void B();


    //接口是不能有普通方法的
    void A();

    //可以有static方法，默认且只能 是default static 修饰
    static void testInterface() {
        System.out.println("JDK1.8可以使用static修饰接口的普通方法");
    }

    //    Interface abstract methods cannot have body
//    public void test(){
//
//    }
    //接口.方法名可以调用方法
    public static void test() {
        TestInterFace2.testInterface();
    }
    //可以不写，默认是继承
    @Override
    void run();

}
