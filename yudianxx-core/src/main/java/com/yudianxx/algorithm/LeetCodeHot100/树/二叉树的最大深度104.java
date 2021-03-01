package com.yudianxx.algorithm.LeetCodeHot100.树;

/**
 * @author huangyongwen
 * @date 2021/1/21
 * @Description
 */

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *      \
 *      7
 * 返回它的最大深度 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的最大深度104 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(7);

        /**
         *  * 3
         *  * / \
         *  * 9  20
         *  * /  \
         *  * 15   7
         *  *      \
         *  *      7
         */
        System.out.println(maxDepth(treeNode));

    }

    /**
     * 官方题解
     *
     * 递归遍历。
     *
     *
     * @param root
     * @return
     */
    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        //如何区分左右树，可以递归两次
        int left = depth + maxDepth(root.left);
        int right = depth + maxDepth(root.right);
        return Math.max(left, right);
    }

}
