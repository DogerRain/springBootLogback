package com.yudianxx.basic.基本数据类型;

public class 拆箱和装箱 {
    public static void main(String[] args) {
//        IntegerTest3();
        new Test2().test();

    }

    public void IntegerTest(){
        Integer a = 1;
        int b = 1;
        Integer c = Integer.valueOf(1);
        Integer d = new Integer(1);

        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(c == d);

        //拆箱 Integer 转 int
        //装箱 int 转 Integer
        String[] str = new String[2];

        Object[] str1 = str;

        str[0] = "abc";

        int a1 = Integer.valueOf("123");

        int a2 = Integer.valueOf(1);

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }

    }

    public void IntegerTest2() {
        int a = 100;
        int b = 100;
        int c = 2000;
        int d = 2000;

        Integer e = 100; //等于Integer e = Integer.valueOf(100);
        Integer f = 100;
        Integer g = 200;
        Integer h = 200;

        Integer ee = Integer.valueOf(100);   //源码valueOf是一个static的Integer对象，valueOf是有一个小于128的判断
        Integer ff = Integer.valueOf(100);

        //new 的话地址肯定是不等的
        Integer i = new Integer(100);  //new Integer没有拆箱操作,最后返回的是一个value
        Integer k = new Integer(100);
        Integer l = new Integer(200);

//        System.out.println("a == b 》》》"+(a == b)); //true
        System.out.println("c == d 》》》" + (c == d)); //true
        System.out.println("e == f 》》》" + (e == f));
        System.out.println("g == h 》》》" + (g == h));

        System.out.println("i == k 》》》" + (i == k));

//        System.out.println("a == 100 》》》"+(a == 100)); //true
        System.out.println("a == e 》》》" + (a == e));
        System.out.println("c == g 》》》" + (c == g));  //g最后会自动拆箱的，拆箱之后返回的是一个value

        System.out.println("a == i 》》》" + (a == i));  //
        System.out.println("f == i 》》》" + (f == i));  //
        System.out.println("g == l 》》》" + (g == l));  //

        System.out.println("ee ==ff 》》》" + (ee == ff));
    }


    public static void IntegerTest3(){
        int i =201;
        Integer j = new Integer(201);

        Integer k = 1;
        System.out.println(j==i);

    }

    public static class Test2
    {
        //这里的add只是一个副值传递，并不会影响原来的值
        public void add(Byte b)
        {
            b = b++;
        }
        public void test()
        {
            Byte a = 127;
            Byte b = 127;
            add(++a); //byte的值在 -128 ~ 127  ++a会越界，a的值变为-128
            System.out.print(a + " ");
            add(b);
            System.out.print(b + "");
        }
    }



}
