package com.yudianxx.algorithm.sort;

/**
 * @author huangyongwen
 * @date 2020/7/1
 * @Description
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 参考：https://mp.weixin.qq.com/s/uQb5W-vO-SMQyJsNHd_PMw
 */
public class 冒泡排序 {

    public static void main(String[] args) {


        HashMap<String, String> ext = new HashMap<String, String>(){
            {
                put("key", "value");
            }
        };




        int[] nums = new int[]{5, 1, 4, 2, 8, 4};

        sort1(nums);


        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

    /**
     * 不考虑优化的实现方式
     */

    public static void sort1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length - i - 1; j++) {
                //交换
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }


    }

}
