package com.yudianxx.basic.String;

/**
 * @author huangyongwen
 * @date 2020/4/22
 * @Description
 */
public class EqualsTest {
    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        String c = a;

        String d = new String("a"); //常量池已经有a了，返回一个引用给d


        System.out.println(a==b);

        System.out.println(a==c);
        System.out.println(a.equals(c));


        //==比较的是引用常量池的地址以及内容，地址不一样，但是内容一样。
        System.out.println(a==d);
        //equals比较的是内容，string字符串在常量池的值
        System.out.println(a.equals(d));





    }
}
