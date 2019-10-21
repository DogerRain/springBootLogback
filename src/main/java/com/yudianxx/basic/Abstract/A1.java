package com.yudianxx.basic.Abstract;

public class A1 {
    //    java提供的两种多态的机制：
//    父类或接口定义的引用变量可以指向子类或具体实现类的实例对象，
//    而程序调用的方法在运行期才动态绑定，就是引用变量所指向的具体
//    实例对象的方法，也就是内存里正在运行的那个对象的方法，而不是
//    引用变量的类型中定义的方法。
//    1. 通过子类覆盖父类的方法。
//    2. 重载。
    public void menthod_one() {
        System.out.println("A");
    }

}


class B1 extends A1 {
//    public void menthod_one() {
//        System.out.println("B");
//    }


    public static void main(String[] args) {
        A1 a = new A1();
        B1 b = new B1();
        C1 c = new C1();

        A1  a1 = new B1();
        a1.menthod_one();
//        a = (A1) b;  //     相当于  A1  a = new B1(); 向下转型,通过父类实例化子类，指向了子类的引用
        c.menthod_one();
//        c = (C1) a;
//        c.menthod_one();

    }

}

class C1 extends A1 {
    public void menthod_one() {
        System.out.println("C");
    }
}




