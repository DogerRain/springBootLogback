package com.yudianxx.basic.基本数据类型;

import javax.swing.tree.TreeNode;

/**
 * @author huangyongwen
 * @date 2020/9/9
 * @Description
 */
public class 默认数据类型 {


    String defaultValue;

    byte a;
    boolean b;
    char c;
    short d;
    int e;
    long f;
    float g;
    double h;

    void methodB() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
    }


    public void methodA() {
        System.out.println("1h黄！!".length());

        int _21 = 1;
        int w = 1;

        //java浮点数默认是double 的 ,不加f 就是double，这样转换就会报错的

        float num2 = (float) 1.1;
        float num3 = 1.1f;
        Float num4 = 1.1f;
//        float num1 = 1.1;


        double num5 = 1.1;


        System.out.println("num2 == num4 :" + (num2 == num4));
        System.out.println("num2 == num4 :" + (num3 == num4));

        double d111 = 1.1;
        double d222 = 5.3e12;
        double d2 = 1; //
        Double d4 = 1d;
        Double d333 = 1.1d;
        Double d444 = 1.1;


        TreeNode treeNode;

        long l = 2l;
        short s = 2;
        System.out.println(l == s);
    }

    public void calculate() {
        int i = 1;
        i = i++; //1
        int j = i++; //2
        int k = i + ++i * i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);
        int l = 2;
        System.out.println(1 + ++l * l++);
    }

    public void defaultValue() {
        String str;
        //局部
//        String str1 =str;
        //全局
        String str2 = defaultValue;

        //想一下类加载过程，在准备的阶段已经开始 分配默认值了。而 方法声明 在方法区，局部变量在栈 ， 不初始化默认值怎么可能使用。


    }

    public static void main(String[] args) {
        new 默认数据类型().methodB();

        String a = "1";
        int b = 1;
        int c = 2;
        System.out.println(a + b + c); //112
        System.out.println(b + c + a); //31


        String str = "-12";
        int num = Integer.parseInt(str);
        System.out.println(num); // -12

        Integer num2 = Integer.valueOf(str);
        System.out.println(num2); // -12

//        int numStr= Integer.parseInt("HaC");

        int num3 = Integer.parseInt("134");

        Integer num4 = Integer.valueOf("134").intValue();
        System.out.println(num3 == num4); //

    }


}
