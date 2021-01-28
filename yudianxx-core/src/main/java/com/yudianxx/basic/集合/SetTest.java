package com.yudianxx.basic.集合;

import org.redisson.misc.Hash;

import java.util.*;

/**
 * @author huangyongwen
 * @date 2021/1/27
 * @Description
 */

class Car {
    String number;
    String carName;

    Car(String number, String carName) {
        this.number = number;
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", carName=" + carName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(this.number, car.number) &&
                Objects.equals(this.carName, car.carName);
    }

    //重写hashCode
    @Override
    public int hashCode() {
        return Objects.hash(number, carName);
    }
}

public class SetTest {
    public static void main(String[] args) {
        testHashSet();
    }

    static void testHashSet() {
        HashSet<Car> hashSet = new HashSet();
        Car baoMa1 = new Car("粤Z8888", "宝马X5");
        Car baoMa2 = new Car("粤Z8888", "宝马X5");
        System.out.println(baoMa1.equals(baoMa2));
        hashSet.add(baoMa1);
        hashSet.add(baoMa2);
        System.out.println(hashSet);

        Map<Car, String> hashMap = new HashMap<>();
        hashMap.put(baoMa1, "小哈");
        hashMap.put(baoMa2, "小明");
        System.out.println(hashMap);

    }


    static void testLinkedHashSet() {
        Set linkedHashSet = new LinkedHashSet();
    }

    static void testTreeSet() {
        Set treeSet = new TreeSet();


    }
}
