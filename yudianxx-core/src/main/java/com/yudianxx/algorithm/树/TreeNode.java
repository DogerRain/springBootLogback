package com.yudianxx.algorithm.树;

/**
 * @author huangyongwen
 * @date 2020/12/24
 * @Description
 */
public class TreeNode {
    int val;
    static TreeNode left;
    static TreeNode right;

    public TreeNode(int val){
        this.val =val;
    }

    static void printNode(TreeNode treeNode){
        System.out.print(treeNode.val + " ");
    }

}
