package com.yudianxx.algorithm.LeetCodeHot100.树;

/**
 * @author huangyongwen
 * @date 2021/3/1
 * @Description 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * 路径长度 即 / \ 斜杠的数量，不是节点的数量
 *
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
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(2);
        treeNode.left.left.right = new TreeNode(3);
        treeNode.left.right.right = new TreeNode(8);
        treeNode.left.left.left.left = new TreeNode(4);
        treeNode.left.right.right.right = new TreeNode(9);
//        该树表示为
        /**
         *       *  1
         *       * / \
         *        2   3
         *       / \
         *      1   4
         *     / \   \
         *    2   3   8
         *   /         \
         *  4           9
         *
         * [ 4,2,1,2,4,8,9 ] = 6
         */
        System.out.println(diameterOfBinaryTree(treeNode));
    }

    /**
     *
     * 评论区
     *
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    /**
     * 递归，
     * 计算每个节点的最大深度：每个节点的最大深度=左+右，因为可能不经过根节点，所以用一个max
     * 存储
     *
     * 然后还没完，因为直径不一定经过根节点，还需要把左右最长的一条返回给上一层（也就是上一个节点），
     * 上一个节点就会根据这个节点的最大深度进行下一步
     *
     *
     * @param root
     * @return
     */
    static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int Left = depth(root.left);
        int Right = depth(root.right);
        max = Math.max(Left + Right, max);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(Left, Right) + 1;//返回节点深度
    }
}
