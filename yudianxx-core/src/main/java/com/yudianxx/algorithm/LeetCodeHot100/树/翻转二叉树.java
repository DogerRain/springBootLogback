package com.yudianxx.algorithm.LeetCodeHot100.树;

/**
 * @author huangyongwen
 * @date 2021/1/14
 * @Description
 */


/*

翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/invert-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */


public class 翻转二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        invertTree(root);
    }

    /**
     * 递归翻转，不应该交换值，应该整颗树翻转
     *
     * @param root
     * @return
     */
    static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //从上往下翻转
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //递归，得到最后一个左树
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    /**
     * 从下往上翻转
     *
     * 加点想象力理解递归
     * @param root
     * @return
     */
    static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);

        root.right = left;
        root.left = right;


        return root;


    }
}
