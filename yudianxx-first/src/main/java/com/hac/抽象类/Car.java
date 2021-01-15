package com.hac.抽象类;

/**
 * @author huangyongwen
 * @date 2021/1/12
 * @Description
 */
public abstract class Car {
    abstract void drive();
}

class BaoMa extends Car {
    @Override
    void drive() {
        System.out.println("系安全带");
        System.out.println("启动");
        System.out.println("我在开宝马");
    }
}

class Test{
    public static void main(String[] args) {
//        Car car = new  Car(); //不能实例化，会报错
        BaoMa baoMa = new BaoMa();
        baoMa.drive();
    }
}