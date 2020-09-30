package com.yudianxx.interview.Object;

/**
 * @author huangyongwen
 * @date 2020/9/29
 * @Description
 */
public class InstanceofTest {


    public static void main(String[] args) {
        A obj = new D();

        System.out.println(obj instanceof B);

        System.out.println(obj instanceof C);

        System.out.println(obj instanceof D);

        System.out.println(obj instanceof A);


    }
}

class A {
}

class B extends A {
}

class C extends A {
}

class D extends B {
}