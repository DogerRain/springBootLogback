package com.yudianxx.interview.String;

public class StringAll {
    public static void main(String[] args) {
        String s = "祝你考出好成绩!";
        System.out.println(s.length());
    }
}
class Animal{
    public void move(){
        System.out.println("动物可以移动");
    }
    public void climb(){
        System.out.println("动物可以爬");
    }
}
class Dog extends Animal{
    @Override
    public void move(){
        System.out.println("狗可以跑和走");
    }
    public void bark(){
        System.out.println("狗可以吠叫");
    }
}

class TestDog{
    public static void main(String args[]){
        Animal a = new Animal();
        Dog d  =new Dog();
        Animal ad = new Dog();
//        普通对象
        a.move(); //动物可以移动
        d.move(); //狗可以跑和走
//        父类引用指向来子类对象  方法必须要子类继承父类，调用的是子类的方法
        ad.move(); //狗可以跑和走
//        ad.bark();   //编译报错
        ((Dog) ad).bark();  //狗可以吠叫
//        普通对象
        ad.climb();   //动物可以爬

    }
}