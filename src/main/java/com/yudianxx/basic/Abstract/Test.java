package com.yudianxx.basic.Abstract;

class A {
    public void print() {
        System.out.println("A:print");
    }
}

class B extends A {
    public void print() {
        System.out.println("B:print");
    }
    public void funcB(){
        System.out.println("funcB");
    }
}

class C extends A {
    public void print() {
        System.out.println("C:print");
    }
    public void funcC(){
        System.out.println("funcC");
    }
}

public class Test{
    public static void func(A a)
    {
        a.print();
        if(a instanceof B)
        {
            B b = (B)a;   //向下转型,通过父类实例化子类
            b.funcB();    //调用B类独有的方法
        }
        else if(a instanceof C)
        {
            C c = (C)a;  //向下转型,通过父类实例化子类
            c.funcC();   //调用C类独有的方法
        }
    }

    public static void main(String args[])
    {
        func(new A());
        func(new B());
        func(new C());
    }
}
