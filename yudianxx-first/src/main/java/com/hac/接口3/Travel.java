package com.hac.接口3;

/**
 * @author huangyongwen
 * @date 2021/1/13
 * @Description
 */
interface AerospaceOffice { //航空局规定的开飞机接口
    void fly();
}
interface TrafficControlOffice {
    void drive();   //车管所规定的drive()
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

public class Travel {

    void flyToPlay(AerospaceOffice aerospaceOffice){
        aerospaceOffice.fly();
    }

    public static void main(String[] args) {


        Travel travel = new Travel(); //去旅行
        Driver driver = new Driver(); //请司机
        travel.flyToPlay(driver);//让司机开飞机

        HaC haC = new HaC();  //亲自来
        travel.flyToPlay(haC);//亲自来开飞机

    }
}
