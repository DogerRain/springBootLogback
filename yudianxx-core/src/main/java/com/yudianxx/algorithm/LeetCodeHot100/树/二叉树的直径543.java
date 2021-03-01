package com.yudianxx.algorithm.LeetCodeHot100.树;

/**
 * @author huangyongwen
 * @date 2021/3/1
 * @Description 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 *  
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 *  
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的直径543 {
    static int max = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(treeNode));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = depth(root.left) ;
        int right = depth(root.right);
        return Math.max(right + left, Math.max(right, left));
    }

    static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int length = 1;
        int left = length + depth(root.left);
        int right = length + depth(root.right);
        return Math.max(left, right);
    }
}
