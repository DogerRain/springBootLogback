package com.yudianxx.basic.duotai;

public class Chongzai {

    public static void main(String[] args) {
//        A a = new A();
//        B b = new B();
//        C c = new C();
//        A a = new B();
//        a.same();
//        a.a();
//        a = (B) a;
//        a.same();
//        ((B) a).same();
//        ((B) a).b();
//        A ab = new B(1);  //看new B() 的构造函数
//        B bc = new C();
//        C c = new C();
//        A a = new A();
//        a.same();
//        a = (B) a; //错误 大概等价于 C a = new A() ？
        B b =new C();
        b.same();
        b =(C) b; //等价于 C cc = (C) b; cc与b一样
//        cc.same();

//        b = (C) b;
//        b.same();


//        c.b();
//        c.a();

    }
}

class A {
    public A(int i) {
        System.out.println("construct A:" + i);
        same();
    }

    public A() {
        System.out.println("construct A");
        same();
    }

    public void same() {
        System.out.println("A");
    }

    public void a() {
        System.out.println("a");
    }
}

class B extends A {
    public B() {
//        super();  //默认调用父类的无参构造方法，可写可不写，如果调用有参的则不会默认调用无参的
//        super(1);
        System.out.println("construct B");
        same();
    }

    public B(int i) {
        //默认调用父类的无参构造方法，可写可不写，如果调用有参的则不会默认调用无参的
        System.out.printf(i + "");
    }

    public void same() {
        System.out.println("B");
    }

    public void b() {
        System.out.println("b");
    }
}

class C extends B {
    public C() {
        System.out.println("construct C");
        same();
    }

    public void same() {
        System.out.println("C");
    }

    public void c() {
        System.out.println("c");
    }
}