package com.yudianxx.algorithm.LeetCodeHot100;

/**
 * @author huangyongwen
 * @date 2021/1/25
 * @Description
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 只出现一次的数字136 {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 2, 1};
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
    }

    /**
     * 我自己的方法
     * O（n^2）
     *
     * @param nums
     * @return
     */
    static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return nums[i];
            }
        }
        return result;
    }

    /**
     * 先排序再移位，
     * O（n/2），可能不是
     *
     * @param nums
     * @return
     */
    static int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ) {
            if (i + 1 < nums.length && (nums[i] == nums[i + 1])) { //如果是最后一位则不能i+1
                i = i + 2;
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 任何和0异或的数，都是原来的数
     */
    static int singleNumber3(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    /**
     * hashSet
     *
     * @param nums
     * @return
     */
    public static int singleNumber_HashSet(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 尝试将当前元素加入 set
            boolean flag = set.add(nums[i]); //false 表示无法add，即已存在
            if (!flag) {
                // 当前元已经存在于 set，即当前元素第二次出现，从 set 删除
                set.remove(nums[i]);
            }
        }
        // 最后只剩一个不重复的元素
        return set.iterator().next();
    }

}
