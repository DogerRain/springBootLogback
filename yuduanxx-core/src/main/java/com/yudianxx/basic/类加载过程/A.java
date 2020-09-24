package com.yudianxx.basic.类加载过程;

/**
 * @author huangyongwen
 * @date 2020/9/14
 * @Description
 */


public class A {
    public A() {
        System.out.println("class A");
    }

    {
        System.out.println("I'm A class");
    }

    static {
        System.out.println("class A static");
    }
}

class B extends A {
    public B() {
        System.out.println("class B");
    }

    {
        System.out.println("I'm B class");
    }

    static {
        System.out.println("class B static");
    }

    public static void main(String[] args) {
        new B();
    }
}

class Demo {
    class Super {
        int flag = 1;

        Super(){
            test();
        }

        Super(String flag) {
            System.out.println(flag);
        }

        void test() {
            System.out.println("Super.test() flag=" + flag);
        }
    }

    class Sub extends Super {
        Sub(int i) {
            super();
            flag = i;
            System.out.println("Sub.Sub()flag=" + flag);
        }

        void test() {
            System.out.println("Sub.test()flag=" + flag);
        }
    }

    public static void main(String[] args) {
        new Demo().new Sub(5);
    }
}

