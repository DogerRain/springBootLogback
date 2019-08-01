package com.yudianxx.algorithm;


//nums = [2, 7, 11, 15], target = 9

import java.util.HashMap;
import java.util.Map;

public class solution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] result = new int[0];
        try {
//            result = new solution().twoSum1(nums, target);
            result = new solution().twoSum2(nums, target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null) {
            System.out.println("没有找到");
            return;
        }
        System.out.println("[" + result[0] + "] [" + result[1] + "]");
    }


    //    暴力遍历，时间复杂度O(n^2)
    public int[] twoSum1(int[] nums, int target) throws Exception {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //    hashMap key是值，value是下标 时间复杂度是O(2n)即O(n)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
//           map.get(complement) !=i 因为数组数据不重复，差值不能是本身
            if (map.containsKey(complement) && map.get(complement) != i) {
//                找到
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }
}
