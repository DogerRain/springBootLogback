package com.yudianxx.algorithm.LeetCodeHot100;

import com.yudianxx.algorithm.树.MyTreeNode;

/**
 * @author huangyongwen
 * @date 2020/9/15
 * @Description
 */
public class 合并二叉树 {
    public static void main(String[] args) {

        MyTreeNode treeNode1 = new MyTreeNode(1);

        treeNode1.left = new MyTreeNode(3);
        treeNode1.right = new MyTreeNode(2);
        treeNode1.left.left = new MyTreeNode(5);

        MyTreeNode treeNode2 = new MyTreeNode(2);
        treeNode2.left = new MyTreeNode(1);
        treeNode2.right = new MyTreeNode(3);
        treeNode2.left.right = new MyTreeNode(4);
        treeNode2.right.right = new MyTreeNode(7);

        MyTreeNode myTreeNode = new MyTreeNode();
        myTreeNode.preOrder(mergeTrees(treeNode1, treeNode2));
        System.out.println();
        myTreeNode.preOrder(mergeTrees2(treeNode1, treeNode2));

    }

    public static MyTreeNode mergeTrees(MyTreeNode t1, MyTreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        MyTreeNode newTree = new MyTreeNode(t1.val + t2.val);
        newTree.left = mergeTrees(t1.left, t2.left);
        newTree.right = mergeTrees(t1.right, t2.right);
        return newTree;
    }


    static MyTreeNode mergeTrees2(MyTreeNode t1, MyTreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees2(t1.left, t2.left);
        t1.right = mergeTrees2(t1.right, t2.right);

        return t1;

    }


}
