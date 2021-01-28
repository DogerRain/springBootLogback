package com.yudianxx.algorithm.LeetCodeHot100;

/**
 * @author huangyongwen
 * @date 2021/1/26
 * @Description
 */

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 * <p>
 * 进阶：
 * <p>
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 多数元素169 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement1(nums));
        System.out.println(majorityElement2(nums));
    }

    static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * @param nums
     * @return
     */
    static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] == nums[nums.length / 2]) {
            return nums[0];
        } else {
            return nums[nums.length / 2 + 1];
        }
    }

    /**
     * 摩尔投票
     *
     * @param nums
     * @return
     */
    static int majorityElement2(int[] nums) {
        int first = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (first == nums[i]) {
                count++;
            } else {
                count--;
            }
            //对消完毕，投给下一位
            if (count == 0) {
                count = 1;
                first = nums[i];
            }
        }
        return first;
    }
}

