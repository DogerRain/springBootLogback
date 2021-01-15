package com.hac.four面向对象;

/**
 * @author huangyongwen
 * @date 2021/1/11
 * @Description
 */
public class Car {
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }


    public void printCarName() {
        System.out.println("车的名字：" + this.carName);
    }

    protected void printCarName(int carAge) {
        System.out.println("车的名字：" + this.carName + "，车龄：" + carAge);
    }

    protected String printCarName(int carAge, int kilometre) {
        System.out.println("车的名字：" + this.carName + "，车龄：" + carAge + "，公里数：" + kilometre);
        return "";
    }

//    public void setCarName(String carName) {
//        this.carName = carName;
//    }

//    public void setCarName(String carName1, String carName2) {
//        this.carName = carName1 + "，" + carName2;
//    }

//    public void setCarName(String... names) {
//        String carName = "";
//        for (int i = 0; i < names.length; i++) {
//            carName += names[i] + "，";
//        }
//        this.carName = carName.substring(0, carName.length() - 1);
//    }

}

class HaC {
    public static void main(String[] args) {
        Car car = new Car("AE86");
        car.printCarName();
        car.printCarName(3);
        car.printCarName(3, 100000);
    }
}