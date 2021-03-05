package com.yudianxx.algorithm.LeetCodeHot100;

import io.swagger.models.auth.In;

import java.util.*;

/**
 * @author huangyongwen
 * @date 2021/2/2
 * @Description
 */

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 找到所有数组中消失的数字448 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
//        List<Integer> list = findDisappearedNumbers(nums);
        List<Integer> list = findDisappearedNumbers2(nums);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    /**
     * 自己的方法，遍历两次，复杂度还是 O(n)，但开辟了新对象
     *
     * @param nums
     * @return
     */
    static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            if (hashMap.get(j + 1) == null) {
                list.add(j + 1);
            }
        }
        return list;
    }

    /**
     * 官方题解，O（n），空间复杂度O（1），一种规律
     * <p>
     * 思想就是通过值作为下标，把下标对应的值修改为负数
     * 为什么是负数，而且还是-1，那是因为绝对值还是本身,这个本身还是要用做下标的
     *
     * @param nums
     * @return
     */
    /**
     * [4,3,2,7,8,2,3,1]
     *
     * 变成索引i：
     * [3,2,1,6,7,1,2,0]
     *
     * nums[i] 乘 -1
     * [-1,-3,-2,-7,8,2,-3,-1]
     */
    static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //把值变成下标
            int index = Math.abs(nums[i]) - 1;
            // 下标对应的值 *-1，让其变成负数，如果没有乘以-1的，上一步就溢出或者没意义了
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                list.add(j + 1);
            }
        }
        return list;
    }

}
