package com.yudianxx.basic.接口;

public class RealizeInterface extends RealizeInterfaceSuper implements TestInterFace {
    RealizeInterface(){
        System.out.println("我是子类，我是构造方法");
        System.out.println(super.getNum());
    }

    int num =11;

    public void A(){
        //接口名.变量拿到常量名称
        System.out.println(TestInterFace.a);
    }

//    @Override
//    public int getNum(){
//        return num;
//    }

    @Override
    public void B() {

    }

    //必须实现父类的父类的方法
    @Override
    public void run() {

    }


//    @Override
//    public int getNumProtected(){
//        return num;
//    }

    //虽然接口也有一样的方法名称，但是接口是static的，不影响
    public void testInterface(){
        System.out.println("我只是实现类的方法，不是接口的方法");
    }

    public static void main(String[] args) {
        //构造方法，先调用父类再到子类
        RealizeInterface realizeInterface=  new RealizeInterface();

        realizeInterface.testInterface();

        System.out.println(realizeInterface.getNum());
        realizeInterface.A();

        System.out.println(realizeInterface.getNumProtected());


    }
}
