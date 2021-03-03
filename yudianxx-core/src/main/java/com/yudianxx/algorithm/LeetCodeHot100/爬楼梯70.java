package com.yudianxx.algorithm.LeetCodeHot100;

/**
 * @author huangyongwen
 * @date 2021/3/3
 * @Description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 爬楼梯70 {
    public static void main(String[] args) {
        System.out.println(climbStairs2(3));
    }

    /**
     * 老老实实递归，妈的超时了
     * 时间复杂度：O(2^n)
     *
     * @param n
     * @return
     */
    static int climbStairs(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    /**
     * 评论区人才，
     * DP数组 迭代解法
     * 空间复杂度 O(n)
     *
     * @param n
     * @return
     */
    static int climbStairs3(int n) {
        int[] dp = new int[n + 2]; //该数组每个元素的指针对应的是台阶数,元素的值存放的是台阶数对应的方法数
        //dp[0] = 0; //不管怎样,数组下标指针肯定是从0开始的,所以要考虑0.有0个台阶,不需要爬,所以没有方法数(但从斐波那契角度,dp[0]=1)
        dp[1] = 1; //1阶台阶,只有一种方式(1)

        //2阶台阶,有两种方式(1+1, 2), 因为题目设定n是正整数,所以n最小是1,此时如果定义dp的长度是int[n + 1],则length=2
        //而dp[2]实际对应的是第三个元素,超出length了,所以定义new int[n + 2]更合理
        dp[2] = 2;

        //从第三个台阶开始遍历,第三个台阶,是第二个台阶的方法和第一个台阶的方法之和
        //第四个台阶,是第三个台阶和第二个台阶方法之和,依此论推....
        for (int i = 3; i <= n; i++) { //要遍历到第n个台阶,所以指针其实是从0到n,所以dp数组数量比n多1
            dp[i] = dp[i - 1] + dp[i - 2]; //最后到第n个台阶,得到结果后正好遍历完
        }

        return dp[n];
    }

    /**
     * 进阶，备忘录存旧值
     * <p>
     * 其实是个斐波那契数列
     * <p>
     * 空间复杂度降为 O(1)
     * <p>
     * 阶   解
     * 1    1
     * 2    2
     * 3    3
     * 4    5
     * 5    8
     */
    static int climbStairs2(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        int a = 1; //上一阶
        int b = 2; //当前阶
        for (int i = 3; i <= n; i++) {
            int temp = a;
            a = b;
//            只要想办法存储之前的两个状态就行了
            b = temp + a;
        }
        return b;
    }

}
