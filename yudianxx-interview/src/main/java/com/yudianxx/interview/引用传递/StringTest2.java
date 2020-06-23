package com.yudianxx.interview.引用传递;

/**
 * @author huangyongwen
 * @date 2020/6/23
 * @Description
 */
public class StringTest2 {
    public static void main(String[] args) {

//        StringBuilderTest();
//        internTest();
        concactTest3();
    }

    static void other() {
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
        System.out.println(s3 == s4);  //1.6为false ，1.7为true
        System.out.println(t1 == s4); //t
        System.out.println(t1 == s3);//t
        System.out.println(s4 == s5);//f
    }

    static void concatTest() {
        final String s = "a"; //注意:这里s用final修饰，相当于一个常量
//         String s = "a"; // 没有final，走StringBuilder
        String str5 = s + "b";
        System.out.println(str5 == "ab");  //true


        String s1 = "a";
        String s2 = "b";
        String str6 = s1 + s2;   //走StringBuilder,StringBuilder的最后一步toString()方法还原一个新的String对象"ab"，因此堆中开辟一块空间存放此对象,str6指向这个对象
        System.out.println(str6 == "ab"); //f， "ab"在常量池

        String str7 = "abc".substring(0, 2);
        /**
         *   步骤：
         *
         *         1) 栈中开辟一块空间存放引用str7，
         *
         *         2) substring()方法还原一个新的String对象"ab"（不同于str6所指），堆中开辟一块空间存放此对象，
         *
         *         3) 引用str7指向堆中的新String对象，
         */
        System.out.println(str7 == "ab"); //f

    }

    static void concactTest2() {


        String s = "abc";

        String s1 = s;

        System.out.println(s1 == "abc");

        s = s + "hello";

        System.out.println(s1 == "abc");

        System.out.println(s == "abchello");

        /**
         *        步骤：
         *
         *         1）栈中开辟一块空间存放s；
         *
         *         2）Sting池中开辟一块空间用于存放"abc"，栈中开辟一块空间存放变量s1；
         *
         *         3）系统输出true，在堆中开辟一块空间用于存放"abchello"；
         *
         *         4）引用s指向堆中的"abchello"；
         *
         *         5）系统输出true，然后输出false；
         */
    }

    /**
     * 仔细研究一下这个
     */


    static void concactTest3() {

        String str2 = new String("a") + new String("b") + new String("d");  // 只会在常量池创建 a 、b 、d ，没有abd。返回一个堆对象的 abd
        str2.intern(); //常量池 没有 abd ，则在1.7 返回指向堆地址abd的地址，然后指向str2，所以现在str2的地址是指向堆abc，！！！ 以后 = 创建的abd 字符串 都指向了堆地址
        String str3 = "a" + "b" + "d"; //优化，只有一个abc ； str3 指向了 堆
        System.out.println(str2 == str3); //T

        String str22 = new String("a") + new String("b") + new String("d"); //堆中创建新的abd 地址啦
        String str33 = "a" + "b" + "d";
        System.out.println(str22 == str33); //F


        String str0 = "a" + "b" + "c"; //优化，只有一个abc, 指向 常量池
        String str1 = new String("a") + new String("b") + new String("c"); //指向堆
        str1.intern(); //常量池没有，返回地址 指向 堆，所以str1 指向了堆
        System.out.println(str0 == str1); //false

//        String s5 = "123";
        String s4 = new String("123"); //在常量池创建 123，如果有就不用创建， 拷贝一份到堆，因为是局部变量，栈有一个s4，指向堆的 123
        s4 = s4.intern(); //因为常量池有了123，则返回123 的常量池地址
        String s6 = "123"; //常量池有123，不可变的特性。所以为 true
        System.out.println(s4 == s6); //T

    }
}
