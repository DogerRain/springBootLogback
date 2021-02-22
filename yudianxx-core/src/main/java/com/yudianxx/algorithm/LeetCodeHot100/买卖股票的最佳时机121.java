package com.yudianxx.algorithm.LeetCodeHot100;

/**
 * @author huangyongwen
 * @date 2021/2/22
 * @Description 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 买卖股票的最佳时机121 {
    public static void main(String[] args) {
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4, 1, 10, 2};
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 暴力
     * 超时了~
     *
     * @param prices
     * @return
     */
    static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = prices[j] - prices[i] > max ? prices[j] - prices[i] : max;
            }
        }
        return max;
    }

    /**
     * 我自己的解法
     *
     * @param prices
     * @return
     */
    static int maxProfit2(int[] prices) {
        int l = 0;
        int r = prices.length - 1;
        int max = 0;
        while (l != r) {
            max = prices[r] - prices[l] > max ? prices[r] - prices[l] : max;
            //左右同时移动
            if (prices[r] > prices[l]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
