package com.yudianxx.basic.接口;

//这里不是 implement 而是extends
public interface TestInterFace2 {
    int num = 1;
    int a = 1;
    public static int b = 2;
    public static final int c = 2;
    final static int ans = 1;


    //在JDK1.7，接口中只包含抽象方法，使用public abstract
    public abstract void B();

    //    在JDK1.8，接口中新加了默认方法和静态方法：
//    默认方法：使用default修饰，在接口的实现类中，可以直接调用该方法，也可以重写该方法。
//    静态方法：使用static修饰，通过接口直接调用。
    public default void method() {
        System.out.println("default method...");
    }

    //静态方法
    public static void print() {
        System.out.println("static method...");
    }
//    在JDK1.9，接口中新加了私有方法，使用private修饰，私有方法供接口内的默认方法和静态方法调用。
//    public interface Demo{
//        private void method() {
//            System.out.println("Hello World!");
//        }
//    }

    class Vehicle {
        public void run() {
            System.out.println("Vehicle");
        }
    }

    class Car extends Vehicle {
        public static void main(String[] args) {
            new Car().run();
        }

        public final void run() {
            System.out.println("Car");
        }
    }

    class HelloA {
        public HelloA() {
            System.out.println("A init");
        }

        {
            System.out.println("I’m A class");
        }

        static {
            System.out.println("static A");
        }
    }

    class HelloB extends HelloA {
        static {
            System.out.println("static B");
        }

        public HelloB() {
            System.out.println("B init");
        }

        {
            System.out.println("I’m B class");
        }


        public static void main(String[] args) {
            new HelloB();


        }
    }


}
