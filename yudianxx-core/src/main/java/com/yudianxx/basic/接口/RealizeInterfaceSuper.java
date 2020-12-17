package com.yudianxx.basic.接口;

public class RealizeInterfaceSuper {

    RealizeInterfaceSuper(){
        System.out.println("我是父类，我是构造方法");
    }

    int num = 10;

    public int getNum() {
        return num;
    }

    private int getNumPrivate(){
        return num;
    }

    protected int getNumProtected(){
        return num;
    }
}
