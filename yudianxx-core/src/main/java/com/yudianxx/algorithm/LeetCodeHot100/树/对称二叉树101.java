package com.yudianxx.algorithm.LeetCodeHot100.树;

/**
 * @author Administrator
 * @date 2021/2/23 23:45
 * @webSite https://rain.baimuxym.cn
 * @Description 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 对称二叉树101 {

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(2);
        treeNode2.left.right = new TreeNode(3);
        treeNode2.right.right = new TreeNode(3);
        System.out.println(isSymmetric(treeNode2));
    }

    static boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    static boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left.val!=right.val){
            return false;
        }else {
            check(left.left, right.right);
        }
        return true;
    }

}
