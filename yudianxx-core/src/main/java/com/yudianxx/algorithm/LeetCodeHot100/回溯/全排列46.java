package com.yudianxx.algorithm.LeetCodeHot100.回溯;

import java.util.*;

/**
 * @author huangyongwen
 * @date 2021/3/3
 * @Description
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 全排列46 {
    static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     *
     * @param nums
     * @param track
     * 虽然是懂了，但是很难解释
     * [1]的时候，进行回溯，size=1，进入for，包含了1，continue，然后 把 2 加进去
     * 递归，回溯
     * [1,2]的时候， 进入for循环，i=1. size =2 ，进行循环，包含了 1、2，然后循环把 3 进去
     * 递归，回溯
     * [1,2,3]的时候，return ，这时候要取消选择了，[1,2],回到上一层
     * 进入for循环，i=2
     *[1,3]的时候
     */
    static void backtrack(int[] nums, LinkedList<Integer> track) {
        //三位数的排列
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //不允许重复
            if (track.contains(nums[i])) {
                continue;
            }
            //做决策，把数字组合
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums,track);
            //取消选择
            track.removeLast();
        }
    }


    /**
     *
     * 很难理解
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }
}

//全排列教程：
//https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/