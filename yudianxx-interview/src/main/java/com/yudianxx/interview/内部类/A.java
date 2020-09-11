package com.yudianxx.interview.内部类;

//default ,外部类 ，这里可以是 public
 class A {

     //内部类
    public class B {

        class BB{

        }
        //局部内部类 , 相当于就是一个局部变量一样，不需要什么访问修饰符，最多加个final、static
        int a = 1;


        public B getB() {
            return new B();
        }


    }


    public class C {
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

//外部类，这里不能是public，因为 public 修饰的类必须要和文件名一样
class AA {

    public static void main(String[] args) {
        //        B C 都是内部类，不能使用B b = new B(),C c =new C() 直接访问得到
//        B b = new B().getB();

        A.B b =(new A()).new B();
        b.getB();
    }
}


