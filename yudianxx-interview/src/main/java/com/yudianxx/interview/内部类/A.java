package com.yudianxx.interview.内部类;

class A {


    public class B {

        public B getB() {
            return new B();
        }


    }


    class C {
        B b = new B().getB(); //获取B对象


        public C() {
//        B C 都是内部类，不能使用B b = new B(),C c =new C() 直接访问得到
            B b = new B().getB();
            A.B ab = (new A()).new B().getB();
        }


    }

    public class  D{

    }


}

class AA {

    public static void main(String[] args) {
        //        B C 都是内部类，不能使用B b = new B(),C c =new C() 直接访问得到
//        B b = new B().getB();

        A.B b =(new A()).new B();
        b.getB();
    }
}


