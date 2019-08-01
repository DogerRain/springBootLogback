package com.yudianxx.basic;

import com.yudianxx.basic.Abstract.Employee;

public class SuperGetclass extends Employee {

    public SuperGetclass(String name) {
        super(name);
    }


    void getClassName() {
        System.out.println(super.getClass().getName());
        System.out.println(getClass().getSuperclass().getName());
        System.out.println(super.getName());
    }

    public static void main(String[] args) {
        new SuperGetclass("黄勇文").getClassName();
    }

//     System.out.println(super.getClass().getName());
//    打印：
//    I am 黄勇文
//    com.yudianxx.basic.SuperGetclass
//    com.yudianxx.basic.Abstract.Employee
//    黄勇文

//    至于为什么打印com.yudianxx.basic.SuperGetclass，而不是父类的Employee，是因为getClass方法是final的，子类
//    无法重写，继承不了，可以看一下源码，如果要掉用可以使用getSuperCllass()

}
