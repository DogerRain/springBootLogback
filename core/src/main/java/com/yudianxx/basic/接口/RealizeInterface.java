package com.yudianxx.basic.接口;

public class RealizeInterface implements TestInterFace{
    public void A(){

    }

    @Override
    public void run() {

    }

    public void testInterface(){
        System.out.println("我只是实现类的方法，不是接口的方法");
    }

    public static void main(String[] args) {
        RealizeInterface realizeInterface=  new RealizeInterface();
        realizeInterface.testInterface();
    }
}
