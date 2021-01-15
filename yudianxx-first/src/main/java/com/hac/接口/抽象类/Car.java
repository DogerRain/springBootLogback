package com.hac.接口.抽象类;

/**
 * @author huangyongwen
 * @date 2021/1/12
 * @Description
 */

interface TrafficControlOffice {
    void drive();   //车管所规定的drive()
}

interface AerospaceOffice {
    void fly();
}

public class Car implements TrafficControlOffice {
    @Override
    public void drive() {
        System.out.println("平平无奇地开车");
    }
}

class WuLingHongGuang extends Car {
    @Override
    public void drive() {
        System.out.println("开五菱宏光");
    }
}

class BaoMa extends Car {
    @Override
    public void drive() {
        System.out.println("开宝马");
    }
}

class Trunk implements TrafficControlOffice {
    @Override
    public void drive() {
        System.out.println("开大货车");
    }
}


class Driver implements AerospaceOffice {
    public void driveCar(TrafficControlOffice trafficControlOffice) {
        trafficControlOffice.drive();
    }

    @Override
    public void fly() {
        System.out.println("司机可以开飞机去玩了");
    }
}


class HaC implements AerospaceOffice {

    @Override
    public void fly() {
        System.out.println("哈C也可以开飞机去玩了");
    }
}

class Travel {

    void flyToPlay(AerospaceOffice aerospaceOffice){
        aerospaceOffice.fly();
    }


    public static void main(String[] args) {
//        new WuLingHongGuang().drive();//开五菱宏光
//        new Trunk().drive(); //开大货车

//        Driver driver = new Driver(); //请一个司机
//        driver.driveCar(new WuLingHongGuang()); //告诉司机开五菱宏光
//        driver.driveCar(new Trunk());   //告诉司机开大货车

        Travel travel = new Travel(); //去旅行
        Driver driver = new Driver(); //请司机
        travel.flyToPlay(driver);//让司机开飞机

        HaC haC = new HaC();  //亲自来
        travel.flyToPlay(haC);//亲自来开飞机

    }
}


//定义接口
interface TrafficControlOffice1 {
    public static final String name = "HaC";
    public abstract void drive1();
}

interface TrafficControlOffice2 {
    void drive2();
}

interface TrafficControlOffice3 extends TrafficControlOffice1, TrafficControlOffice2 {
    void drive3();
}

//实现接口
class Car1 implements TrafficControlOffice1, TrafficControlOffice2 {
    @Override
    public void drive1() {

    }

    @Override
    public void drive2() {

    }
}