package com.yudianxx.basic.基本数据类型;

import javax.swing.tree.TreeNode;

/**
 * @author huangyongwen
 * @date 2020/9/9
 * @Description
 */
public class 默认数据类型 {
    public void a() {
        System.out.println("1h黄！!".length());

        int _21 = 1;
        int w = 1;

        //java浮点数默认是double 的 ,不叫f 就是double，这样转换就会报错的
        float a111 = 1.1f;
        Float a222 = 1.1f;
        System.out.println(a111 == a222);

        double d111 = 1.1;
        double d222 = 5.3e12;
        double d2 = 1; //
        Double d4 = 1d;
        Double d333 = 1.1d;

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




}
