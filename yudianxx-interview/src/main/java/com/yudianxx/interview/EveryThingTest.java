package com.yudianxx.interview;

import javax.swing.tree.TreeNode;

/**
 * @author huangyongwen
 * @date 2020/7/6
 * @Description
 */
public class EveryThingTest {
    public static void main(String[] args) {
        EveryThingTest everyThingTest = new EveryThingTest();
        everyThingTest.calculate();
    }

    public void preOrderTraverse1(TreeNode root) {
//        if (root != null) {
//            System.out.print(root.val + "->");
//            preOrderTraverse1(root.left);
//            preOrderTraverse1(root.right);
//        }

    }

    public void a() {
        System.out.println("1h黄！!".length());

        int _21 = 1;
        int w = 1;

        EveryThingTest stringTestArray[];
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
