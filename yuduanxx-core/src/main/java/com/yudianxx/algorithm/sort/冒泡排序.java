package com.yudianxx.algorithm.sort;

/**
 * @author huangyongwen
 * @date 2020/7/1
 * @Description
 */

import com.sun.org.apache.bcel.internal.generic.I2F;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考：https://mp.weixin.qq.com/s/uQb5W-vO-SMQyJsNHd_PMw
 */
public class 冒泡排序 {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 1, 4, 2, 8, 4};

        Map map = new HashMap();
        map.put("1", "1");

    }

    /**
     * 不考虑优化的实现方式
     */

    public void sort1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = 1; j < nums.length - i; j++) {
                //交换
                if (nums[i]>nums[j]){
                    int tmp = nums[j];
                    nums[j] =nums[i];
                    nums[i] = tmp;
                }
            }

        }


    }

}
