package com.yudianxx.basic.Abstract;

//        1. 抽象类不能被实例化(初学者很容易犯的错)，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。
//
//        2. 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
//
//        3. 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。
//
//        4. 构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法。
//
//        5. 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。

import lombok.Data;

@Data
public abstract class Employee {
    private String name;
    private String address;
    private int number;
    public Employee(String name){
        this.name=name;
        System.out.println("I am "+ this.name);
    }
    public Employee(String name , String address , int number){
        System.out.println("构造方法，Employee");
        this.name=name;
        this.address=address;
        this.number=number;
    }

    public double computePay(){
        System.out.println("计算 Employee 的工资:"+getName());
        return 0.0d;
    }
    public  void mailCheck(){
        System.out.println("我是Emplyee类");
        System.out.println("工资确认："+this.name+","+this.address);
    }

}
