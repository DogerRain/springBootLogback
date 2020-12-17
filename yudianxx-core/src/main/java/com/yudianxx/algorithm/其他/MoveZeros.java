package com.yudianxx.algorithm.其他;

/**
 * @author huangyongwen
 * @date 2020/8/5
 * @Description
 */

/**
 * 给定一个数组nums，写一个函数，将数组中所有的0挪到数组的末尾，⽽维持其他所有非0元素的相对位置。
 * 举例: nums = [0, 1, 0, 3, 12]，函数运⾏后结果为[1, 3, 12, 0, 0]
 */

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        int[] newNums = new MoveZeros().moveZeroes(0, nums);
        for (int i = 0; i < newNums.length; i++) {
            System.out.print(newNums[i] + " ");
        }

    }

    /**
     *  我自己的方法，建一个新的数组
     * @param target
     * @param nums
     * @return
     */
    int[] moveZeroes(int target, int[] nums) {
        int[] numsCopy = new int[nums.length];
        int k = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                numsCopy[nums.length - l - 1] = nums[i];
                l++;
            } else {
                numsCopy[k] = nums[i];
                k++;
            }
        }
        return numsCopy;
    }

}
