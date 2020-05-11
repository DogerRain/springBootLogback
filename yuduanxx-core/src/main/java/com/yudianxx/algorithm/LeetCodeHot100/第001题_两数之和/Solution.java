package com.yudianxx.algorithm.LeetCodeHot100.第001题_两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangyongwen
 * @date 2020/1/8
 * @Description
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

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) && map.get(num) != i) {
                return new int[]{i, map.get(num)};
            }
        }
        return null;
    }
}
