package com.yudianxx.algorithm.LeetCodeHot100;

/**
 * @author huangyongwen
 * @date 2021/2/25
 * @Description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *  
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最大子序和53 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 动态规划
     *
     * 规律就是：前面的数加起来，只要大于0，肯定是要的
     *
     * @param nums
     * @return
     */
    static int maxSubArray(int[] nums) {
        int max_ending_here = nums[0];
        int max_so_far = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
//            不管前面都长，反正我告诉你截止到你位置最大的值
//            -2, 1, -3, 4, -1, 2, 1, -5, 4
//            -2, 1,  1, 4, 3,  5, 6, 1,  5
            max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    /**
     * 和上面的都是一样的，无法理解
     *
     * @param nums
     * @return
     */
    static int maxSubArray2(int nums[]) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            // if(sum > 0) { 可以写成这样
            if (sum + num > num) {
                sum = sum + num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
