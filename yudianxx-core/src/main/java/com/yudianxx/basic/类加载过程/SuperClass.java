package com.yudianxx.basic.类加载过程;

public class SuperClass {
    static {
        System.out.println("SuperClass 父类静态代码块!");
    }


    SuperClass() {
        System.out.println("SuperClass 父类构造函数");
    }

    {
        System.out.println("SuperClass  父类构造代码块");
    }

    public static int vaule = 123;
}

class SubClass extends SuperClass {

    public static int vaule = 123456;

    static {
        System.out.println("SubClass 子类静态代码块!");
    }

    SubClass() {
        System.out.println("SubClass 子类构造函数");
    }

    //执行顺序 静态代码块 要比 构造代码块 快  ，构造代码块 要比 构造函数 快。
    {
        System.out.println("SubClass 子类构造代码块");
    }
}

class test {
    public static void main(String[] args) {
        SubClass subClassInit = new SubClass(); //一般正常的初始化

        SuperClass[] superClasses = new SuperClass[10]; //通过数组定义引用类，并没有触发SuperClass的初始化阶段
        System.out.println(SuperClass.vaule);

        SubClass[] subClass = new SubClass[1];
        System.out.println(SubClass.vaule);
    }
}

//输出：
//        SuperClass 静态代码块!
//        123
//        SubClass 静态代码块!
//        123456
//静态变量和静态代码块，先在前面的先执行


//父类的静态区>子类的静态区>父类的代码块>父类的构造方法>子类的代码块>子类的构造方法

class StaticStuff {
    static int x = 10;

    static {
        x += 5;
    }

    public static void main(String args[]) {
        System.out.println("x = " + StaticStuff.x);
    }

    static {
        x /= 3;
    }
}
//输出结果 x = 5

class X {
    Y y = new Y();

    public X() {
        System.out.print("X");
    }
}

class Y {
    public Y() {
        System.out.print("Y");
    }
}

class Z extends X {
    Y y = new Y();

    public Z() {
        System.out.print("Z");
    }

    public static void main(String[] args) {
        new Z();
    }
}