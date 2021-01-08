package com.yudianxx.algorithm.LeetCodeHot100;

/**
 * @author huangyongwen
 * @date 2020/12/24
 * @Description
 */
public class 遍历二叉树 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(2);
        treeNode1.left.left = new TreeNode(5);

//        treeNode1.preOrder(treeNode1);

        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(3);
        treeNode2.left.right = new TreeNode(4);
        treeNode2.right.right = new TreeNode(7);


        treeNode2.preOrder(treeNode2);


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        static void printNode(TreeNode treeNode) {
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

}
