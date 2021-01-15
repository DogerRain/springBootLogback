package com.yudianxx.algorithm.LeetCodeHot100;

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

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class 翻转二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        invertTree(root);
    }

    static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //递归，得到最后一个左树
        TreeNode left = invertTree(root.left);

        TreeNode right = invertTree(root.right);

        //交换左右两个子树的值
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return root;
    }

}
