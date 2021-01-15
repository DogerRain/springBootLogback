package com.hac.sixth;

/**
 * @author huangyongwen
 * @date 2021/1/12
 * @Description
 */
public class Car {
    void drive() {
        System.out.println("系安全带");
        //TODO
        System.out.println("点火");
        //TODO
        System.out.println("打灯光");
        //TODO
        System.out.println("拉手刹");
        //TODO
        System.out.println("看后视镜");
        //TODO
        System.out.println("启动");
        //TODO
        System.out.println("平平无奇地开车");
    }
}

class WuLingHongGuang extends Car {
    @Override
    void drive() {
        System.out.println("我在开五菱宏光");
    }
}

class BaoMa extends Car {
    @Override
    void drive() {
        System.out.println("我在开宝马");
    }
}

class AoDi extends Car {
    @Override
    void drive() {
        System.out.println("我在开奥迪");
    }
}

class Driver {
    void driveCar(Car car) {
        car.drive();
    }
}

class Test {
    public static void main(String[] args) {
        WuLingHongGuang wuLingHongGuang = new WuLingHongGuang();
        new Driver().driveCar(wuLingHongGuang);
    }
}