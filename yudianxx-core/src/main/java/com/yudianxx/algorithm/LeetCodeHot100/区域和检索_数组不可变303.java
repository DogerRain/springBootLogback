package com.yudianxx.algorithm.LeetCodeHot100;

/**
 * @author huangyongwen
 * @date 2021/3/1
 * @Description 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 区域和检索_数组不可变303 {
    static class NumArray {
        static int sums[];
        public static void main(String[] args) {
            int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
            new NumArray(nums);
            System.out.println(sumRange(0, 2));
        }
        /**
         * 官方的动态规划
         */
        NumArray(int[] nums) {
            int n = nums.length;
            //sums表示截止到当前的差值
            sums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                //两个相邻之间的差值就是当前数
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        static int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }

        /**
         * 暴力循环
         */
        //        NumArray(int[] nums) {
//            this.nums = nums;
//        }
//
//        static int sumRange(int i, int j) {
//            int sum = 0;
//            for (; i <= j; i++) {
//                sum += nums[i];
//            }
//            return sum;
//        }
    }
}
