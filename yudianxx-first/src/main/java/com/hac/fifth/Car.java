package com.hac.fifth;

/**
 * @author huangyongwen
 * @date 2021/1/11
 * @Description
 */
public class Car {
    private String carName;
    private int carAge;

    Car(String carName, int carAge) {
        this.carName = carName;
        this.carAge = carAge;

    }

    Car() {
        printCar();
    }

    public void printCar() {
        System.out.println("汽车");
    }


}

class WuLingHongGuang extends Car {
    String ChineseName;

    WuLingHongGuang(String carName, int carAge) {
        super(carName, carAge);
        printCar();
    }

    WuLingHongGuang() {

    }

    @Override
    public void printCar() {
        System.out.println("五菱宏光");
    }
}

class Test {
    public static void main(String[] args) {
        Car wuLingHongGuangCar = new WuLingHongGuang();

        Car car = new Car("", 1);

        if (wuLingHongGuangCar instanceof WuLingHongGuang) { //true
            WuLingHongGuang w1 = (WuLingHongGuang) wuLingHongGuangCar; //downcasting
        }
        if (car instanceof WuLingHongGuang) { //false
            WuLingHongGuang w2 = (WuLingHongGuang) car;
        }


    }
}

//
//class BaoMa extends Car {
//    String EnglishName;
//
//    @Override
//    void drive() {
//        System.out.println("开宝马");
//    }
//}

class HaC {
    String ChineseName;
    WuLingHongGuang wuLingHongGuang;
}

class A{
    A(){
        print();
    }
    void print(){
        System.out.println("A");
    }
}
class B extends A{
    @Override
    void print(){
        System.out.println("B");
    }
}
class MyTest{
    public static void main(String[] args) {
        new B();
    }
}