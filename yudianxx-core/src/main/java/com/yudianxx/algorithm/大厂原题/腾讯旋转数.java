package com.yudianxx.algorithm.大厂原题;

/**
 * @author huangyongwen
 * @date 2020/6/22
 * @Description
 *
 * 题目描述：
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 *

/**
 * 最暴力的就是遍历整个数组，取出最小的值，但是这样的时间复杂度是O(n)
 * 旋转数的特点 是有顺序的，可以考虑使用二分查找
 */
public class 腾讯旋转数 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 1, 2};
        System.out.println(minArray(nums));

    }


    public static int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;

        /**
         *           mid到end ，
         *         1. 递增，mid<end，肯定在左边    12345
         *         2. 递减，mid>end，肯定在右边    34512
         *         3. ==的时候，mid = end , 不能确定    12223
         */
        while (start < end) {
            int mid = (start + end) / 2;
            if (numbers[mid] < numbers[end]) {
                end = mid;
            }
            if (numbers[mid] > numbers[end]) {
                start = mid + 1; //要加 1 噢
            }
            if (numbers[mid] == numbers[end]) {
                int result = getMinResult(start, end, numbers);
                return result;
            }
        }
        return numbers[start];
    }

    public static int getMinResult(int start, int end, int[] nums) {
        int min = nums[start];
        for (; start < end; start++) {
            if (min > nums[start]) {
                min = nums[start];
            }
        }
        return min;
    }
}
