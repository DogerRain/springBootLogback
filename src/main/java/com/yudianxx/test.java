package com.yudianxx;

public class test {
    public static void main(String[] args) {
        int a = 100;
        int b = 100;
        int c = 200;
        int d = 200;

        Integer e = 100; //等于Integer e = Integer.valueOf(100);
        Integer f = 100;
        Integer g = 200;
        Integer h = 200;

        Integer ee = Integer.valueOf(100);   //源码valueOf是一个static的Integer对象，valueOf是有一个128的判断
        Integer ff = Integer.valueOf(100);

        //new 的话地址肯定是不等的
        Integer i =new Integer(100);  //new Integer没有拆箱操作,最后返回的是一个value
        Integer k =new Integer(100);
        Integer l =new Integer(200);

//        System.out.println("a == b 》》》"+(a == b)); //true
//        System.out.println("c == d 》》》"+(c == d)); //true
        System.out.println("e == f 》》》"+(e == f));
        System.out.println("g == h 》》》"+(g == h));

        System.out.println("i == k 》》》"+(i == k));

//        System.out.println("a == 100 》》》"+(a == 100)); //true
        System.out.println("a == e 》》》"+(a == e));
        System.out.println("c == g 》》》"+(c == g));  //g最后会自动拆箱的，拆箱之后返回的是一个value

        System.out.println("a == i 》》》"+(a == i));  //
        System.out.println("f == i 》》》"+(f == i));  //
        System.out.println("g == l 》》》"+(g == l));  //

        System.out.println("ee ==ff 》》》"+(ee ==ff));

    }


}
