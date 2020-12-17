package com.yudianxx.algorithm.LeetCodeHot100.第026题_排序数组去重;

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
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5};
        Map<Integer, Integer> map = new HashMap<>();
//        System.out.println(map.put(1, 1));
//        System.out.println(map.put(1, 1));

//        int result = new Solution().removeDuplicates(nums);
        int result = new Solution().removeDuplicates1(nums);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.put(nums[i], i) == null) { //不存在
                nums[j] = nums[i];
                j++;
            }
        }
        return map.size();
    }

    /**
     * 标准答案：双指针
     *
     * 短指针i，长指针j
     */
    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
