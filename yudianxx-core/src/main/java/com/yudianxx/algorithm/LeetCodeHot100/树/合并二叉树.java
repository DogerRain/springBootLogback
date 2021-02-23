package com.yudianxx.algorithm.LeetCodeHot100.树;

/**
 * @author huangyongwen
 * @date 2020/9/15
 * @Description
 */
public class 合并二叉树 {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);

        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(2);
        treeNode1.left.left = new TreeNode(5);

        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(3);
        treeNode2.left.right = new TreeNode(4);
        treeNode2.right.right = new TreeNode(7);

        TreeNode myTreeNode = new TreeNode();
        myTreeNode.preOrder(mergeTrees(treeNode1, treeNode2));
        System.out.println();
        myTreeNode.preOrder(mergeTrees2(treeNode1, treeNode2));

    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        TreeNode newTree = new TreeNode(t1.val + t2.val);
        newTree.left = mergeTrees(t1.left, t2.left);
        newTree.right = mergeTrees(t1.right, t2.right);
        return newTree;
    }


    static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees2(t1.left, t2.left);
        t1.right = mergeTrees2(t1.right, t2.right);

        return t1;

    }


}
