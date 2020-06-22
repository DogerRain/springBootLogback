package com.yudianxx.interview.引用传递;

public class StringTest {
    public static void main(String[] args) {
        // 在编译阶段JVM先去常量池中查找是否存在“abc”，如果过不存在，则在常量池中开辟一个空间存储“abc”。
        // 在运行时期，通过String类的构造器在堆内存中new了一个空间，然后将String池中的“abc”复制一份存放到该堆空间中，
        // 在栈中开辟名字为str2的空间，存放堆中new出来的这个String对象的地址值。
        String s1 = new String("xyz");
        String s2 = new String("xyz");
        String s3 = "xyz";
        String s4 = "xyz";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

        String str = "hello";
        System.out.println(str.hashCode());
        String str1 = str + "world";
        str = str + "world";
        String str2 = "helloworld";
        //常量池 helloworld 的hash值，一样
        System.out.println(str.hashCode());
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

    }

}

class StringTest2 {
    public static void main(String[] args) {

//        StringBuilderTest();
        internTest();

    }

    static void other(){
        String s1 = "ab";
        String s2 = "a";
        String s3 = s2 + "b"; //这里走了StringBuilder进行字符串拼接,然后调用了StringBuilder的toString方法。返回的字符串地址和常量池是不一样的
        String s4 = "a" + "b";
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); //true
        System.out.println(s3 == s4); //true
    }

    //关于StringBuilder，可以看看这个demo
    static void StringBuilderTest() {
        //StringBuilder始终是一个对象
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        System.out.println(stringBuilder.hashCode());
        stringBuilder.append("2");
        System.out.println(stringBuilder.hashCode());
    }


    static void internTest() {
        /**
         *     当调用 intern() 方法时，编译器会将字符串添加到常量池中（stringTable维护），并返回指向该常量的引用。
         * ​        JDK 1.7后，intern方法还是会先去查询常量池中是否有已经存在，如果存在，则返回常量池中的引用，这一点与之前没有区别，.
         *         区别在于，如果在常量池找不到对应的字符串，则不会再将字符串拷贝到常量池，而只是在常量池中生成一个对原字符串的引用。
         *         简单的说，就是往常量池放的东西变了：原来在常量池中找不到时，复制一个副本放到常量池，1.7后则是将在堆上的地址引用复制到常量池。
         */

        String s = new String("1"); //这个s是指向堆的地址
        String t = s.intern();  //即返回一个指向常量池的地址
        String s2 = "1";
        System.out.println(s == t);  //F
        System.out.println(s2 == t); //T



        String s3 = new String("1") + new String("2"); //在堆中有三个对象，但是 常量池只有 1 、2 这两个
        String t1 = s3.intern();
        String s4 = "12";
        String s5 = new String("12");
        System.out.println(s3 == s4);  //1.6为false
        System.out.println(t1 == s4);
        System.out.println(t1 == s3);
        System.out.println(s4 == s5);

    }

}