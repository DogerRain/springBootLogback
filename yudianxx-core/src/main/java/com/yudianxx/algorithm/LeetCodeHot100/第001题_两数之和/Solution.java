package com.yudianxx.algorithm.LeetCodeHot100.第001题_两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangyongwen
 * @date 2020/1/8
 * @Description 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 4;
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = new Solution().twoSum(nums, target);
        if (result == null) {
            System.out.println("没有符合的");
        } else {
            System.out.println("[" + result[0] + "," + result[1] + "]");
        }
    }

    /**
     * 我的解法，使用hashMap的查找辅助
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //放进Map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //目标值-差值
            int num = target - nums[i];
            //查找map是否有答案，但不能是自己，比如 4-2=2
            if (map.containsKey(num) && map.get(num) != i) {
                return new int[]{i, map.get(num)};
            }
        }
        return null;
    }

    /**
     * 暴力循环
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num = target - nums[i];
                if (nums[j] == num) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
