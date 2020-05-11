package com.yudianxx.basic.Abstract;

import lombok.Data;

@Data
public  class  Salary extends Employee{

    private double salary;

    //父类声明了构造方法，子类必须重写；但是父类不声明构造方法，子类不需要重写，默认是创建无参构造函数的，这里涉及到 隐式传递super和this的问题
    public Salary(String name, String address, int number, double
            salary) {
        super(name, address, number);
        setSalary(salary);
    }
    public  void  mailCheck(){
        System.out.println("我是Salary类");
        System.out.println("工资确认"+getName()+", 工资是 "+ getSalary());
    }
    public double computePay(){
        System.out.println("计算 Salary 的工资 : "+ getName());
        return salary/5;
    }


    /**
     * @Author: Administrator
     * @Date: 2019/10/29  15:23
     * @Description:  必须要实现父类抽象方法
     * @Param:
     * @return:
     */
    public void abstrartMethod(){

    }
}