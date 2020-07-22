package com.yudianxx.basic.接口;

/**
 * @author huangyongwen
 * @date 2020/7/22
 * @Description
 */
public class 抽象类和接口 {
    public abstract class abstractClassFather {
        //        普通方法，普通变量
        private String a = "1";
        private final String b = "1";


        public void test() {

        }
//        必须是类是static才行,用static或final修饰的方法不能声明为抽象方法
//        public static void test1(){
//
//        }
//        private static String c = "1";

        public abstract void testabstractClassFather();


    }

    public abstract class abstractClassSon extends abstractClassFather {
        @Override
        public abstract void testabstractClassFather();

        public abstract void testabstractSon();

    }

    public class abstractClassObject extends abstractClassSon {

        @Override
        public void testabstractClassFather() {

        }

        @Override
        public void testabstractSon() {

        }
    }

    //接口


    public interface A {

        String a = "1";

        //interface中的变量都是默认public static final修饰的
        public static final int MAX_LENGTH = 1000;

        default void testAmethod() {

        }

        default void testAmethod2() {
            System.out.println("A");
        }

        //法都是默认public abstract修饰的
        public abstract void testA();

    }

    public interface B {
        void testB();
    }

    //接口可以多继承
    public interface C extends A, B {
        @Override
        default void testAmethod2() {
            System.out.println("C");
        }

    }

    public static class DObject implements C {

        @Override
        public void testA() {

        }

        @Override
        public void testB() {

        }

        @Override
        public void testAmethod2() {
            System.out.println("DObject");
        }

        public static void main(String[] args) {
            DObject d = new DObject();
            d.testAmethod2();
        }

    }
}
