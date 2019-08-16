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

//    打印：
//    I am 黄勇文
//    com.yudianxx.basic.SuperGetclass
//    com.yudianxx.basic.Abstract.Employee
//    黄勇文

//    至于为什么打印com.yudianxx.basic.SuperGetclass，而不是父类的Employee，是因为getClass()方法是final的，子类
//    无法重写，继承不了，可以看一下源码，如果要掉用可以使用getSuperClass()

}
class Single{
    private volatile  static Single single; //  1
    private Single(){}
    public static Single getInstance(){
        if(single==null){   // 2
            //双重检查加锁，只有在第一次实例化时，才启用同步机制，提高了性能。
            synchronized (Single.class) { // 3
                if(single==null){  // 4
                    single=new Single();    //  5
                }
            }
        }
        return single;
    }
}