package com.yudianxx.algorithm.LeetCodeHot100.树;

/**
 * @author huangyongwen
 * @date 2020/12/24
 * @Description
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val =val;
    }

    public TreeNode(){

    }


    static void printNode(TreeNode treeNode){
        System.out.print(treeNode.val + " ");
    }

    //先序遍历
    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printNode(treeNode);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    //中序遍历
    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        preOrder(treeNode.left);
        printNode(treeNode);
        preOrder(treeNode.right);
    }

    //后序遍历
    public static void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        preOrder(treeNode.left);
        preOrder(treeNode.right);
        printNode(treeNode);
    }
}
