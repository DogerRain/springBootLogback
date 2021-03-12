package com.yudianxx.algorithm.LeetCodeHot100.树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangyongwen
 * @date 2021/3/12
 * @Description 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 1
 * /  \
 * null  2
 * /
 * 3
 * <p>
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *  
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的中序遍历94 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        for (Integer i : inorderTraversal3(treeNode)) {
            System.out.print(i + " ");
        }
//        for (Integer i : inorderTraversal(null)){
//            System.out.print(i+" ");
//        }
    }

    /**
     * 方法一，递归，要注意这个 new ArrayList<>()何时创建
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        List<Integer> list = new ArrayList<>();

        list.addAll(left);
        list.add(root.val);
        list.addAll(right);
        return list;
    }

    /**
     * 方法二，官方递归
     *
     * 也是我开始的方法
     *
     * @param root
     * @return
     */
    static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    static List<Integer> result1 = new ArrayList();
    public static List<Integer> inorderTraversal3(TreeNode root) {
        inorder(root);
        return result1;

    }
    static void inorder(TreeNode root){
        if (root==null){
            return;
        }
        inorder(root.left);
        result1.add(root.val);
        inorder(root.right);
    }
}

