package com.yudianxx.algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {
        int nums[] = new int[10];
        Float nums1[] = new Float[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = (int) (Math.random() * 100) + 1;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
//        System.out.println(nums1[1]);
        new QuickSort().quick_sort(nums, 0, nums.length - 1);
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }


    public void quick_sort(int[] nums, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = nums[l]; //l为左下标，r为右下标，x选择第一个数作为比较
            while (i < j) {
                while (i < j && nums[j] >= x) { //从右往左，找到第一个小于x的数
                    j--;
                }
                //找到了，还要判断是否和i重叠
                if (i < j) {
                    nums[i] = nums[j]; //互换
                    i++;  //然后从到左边开始找了
                }
                while (i < j && nums[i] < x) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = x;
            quick_sort(nums,l,i-1);
            quick_sort(nums,i+1,r);

        }
    }
}
