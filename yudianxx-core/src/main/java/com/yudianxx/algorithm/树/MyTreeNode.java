package com.yudianxx.algorithm.树;

/**
 * @author huangyongwen
 * @date 2020/12/24
 * @Description
 */
public class MyTreeNode {
    public int val;
    public MyTreeNode left;
    public MyTreeNode right;

    public MyTreeNode(int val){
        this.val =val;
    }

    public MyTreeNode(){

    }


    static void printNode(MyTreeNode treeNode){
        System.out.print(treeNode.val + " ");
    }

    //先序遍历
    public static void preOrder(MyTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printNode(treeNode);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    //中序遍历
    public static void inOrder(MyTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        preOrder(treeNode.left);
        printNode(treeNode);
        preOrder(treeNode.right);
    }

    //后序遍历
    public static void postOrder(MyTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        preOrder(treeNode.left);
        preOrder(treeNode.right);
        printNode(treeNode);
    }
}
