package com.hac.继承输出顺序;

/**
 * @author huangyongwen
 * @date 2021/1/14
 * @Description
 */
public class Car {
    Car(){
        System.out.println("父类：开车");
    }
}

class WuLingHongGuang extends Car{
    WuLingHongGuang(){
        System.out.println("子类：开五菱宏光");
    }
}

class Test{
    public static void main(String[] args) {
        WuLingHongGuang wuLingHongGuang = new WuLingHongGuang();
    }
}