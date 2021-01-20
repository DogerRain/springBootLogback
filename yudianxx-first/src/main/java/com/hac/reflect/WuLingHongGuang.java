package com.hac.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author huangyongwen
 * @date 2021/1/19
 * @Description
 */

class Car {
    public String carName;
    static {
        System.out.println("这是一辆车");
    }
}

//五菱宏光 类
public class WuLingHongGuang extends Car {
    private String userName = "HaC";

    public WuLingHongGuang(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return this.userName + "的" + this.carName;
    }

    public String getUserName() {
        return userName;
    }
    static {
        System.out.println("这是一辆五菱宏光");
    }
}

class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {
//        WuLingHongGuang wuLingHongGuang = new WuLingHongGuang("五菱宏光");
//        System.out.println(wuLingHongGuang.getUserName());
//        System.out.println(wuLingHongGuang.carName);
//        System.out.println(wuLingHongGuang.getCarName());


        System.out.println("---------分割线-----------");
        Class<?> clz = Class.forName("com.hac.reflect.WuLingHongGuang"); // 取得Class文件
//        Class clz = WuLingHongGuang.class;
        Constructor constructor = clz.getConstructor(String.class);//获得构造方法

        Object object = constructor.newInstance("五菱宏光");//反射实例化对象
        WuLingHongGuang object1 = (WuLingHongGuang) object;
        System.out.println(object1.getCarName());
        Method method = clz.getMethod("getCarName");

        Field nameField1= clz.getDeclaredField("userName"); // 获得userName 属性
        nameField1.setAccessible(true);   //表示可以访问 private 权限
        Field nameField2 = clz.getField("carName"); // 获得父类 carName属性

        System.out.println(nameField1.get(object));
        System.out.println(nameField2.get(object));
        System.out.println(method.invoke(object));


    }
}
class Test2{
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader.getSystemClassLoader().loadClass("com.hac.reflect.WuLingHongGuang");

    }
}