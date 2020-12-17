package com.yudianxx.basic.基本数据类型;

/**
 * @author huangyongwen
 * @date 2020/4/20
 * @Description
 */
public class StringNewObject {
    public static void main(String[] args) {
        String a1 = "a"+"b";  //只创建了一个对象，jdk1.7 会把字符串拼接，编译期进行了优化,即 String a1 ="ab"，估计是 常量池有 a，ab，返回一个ab的引用
        String b1 = new String("a"+"b");  //编译的时候优化了，把它当成 ab 处理了，所以创建一个
    }
}
