package com.yudianxx.basic.基本数据类型;

public class StringBufferTest {
    public static void main(String[] args) {
        String str = "k11";
        String str1 = "k11";
        String str2 = "k11" + "";
        String str3 = str + ""; //这里走了StringBuilder进行字符串拼接,StringBuilder是不会创建对象的,
        //所以说我们在增加字符串长度的时候尽量用StringBuilder，这样会少创建对象，节省资源，提高效率
        System.out.println(str == str1);//true
        System.out.println(str == str2); //true
        System.out.println(str == str3); //false
        int i = 0;
        Integer j = 0;
        Integer k = new Integer(0);
        Integer l = new Integer(0);
        System.out.println(str.equals(i));//true
        System.out.println("jk:" + j.equals(k));//true equals比较的是内容，内容都是 0 肯定相等
        System.out.println("lk:" + l.equals(k));//true
        System.out.println(l == k);//true
        String a = "a";  //存在于方法区，然后再堆中新建一个String类，把String类的char[]引用指向在栈/方法区中的字符串常量
        String b = new String("a"); //new出来的String实例的字符串常量存储在堆上，和栈/方法区无关
        String c = new String("a");
        System.out.println(a == b);//false
        System.out.println(b == c);//false


        StringBuffer stringBuffer = new StringBuffer("1");

        stringBuffer.append("1");




    }

    public void lengthAndCapitity(){
//        StringBuffer s1=new StringBuffer(1); //第一次扩容是2倍+2，如果扩充后的容量还是不够，则直接扩充到需要的容量大小。
        StringBuffer s1=new StringBuffer(4);
        s1.append("12341");
        s1.capacity();
        System.out.println(s1.length()); //
        System.out.println(s1.capacity());//

    }

}


