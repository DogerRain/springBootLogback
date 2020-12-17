package com.yudianxx.algorithm.双向指针;

/**
 * @author huangyongwen
 * @date 2020/9/11
 * @Description
 */

//原题解地址：https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/

public class 盛水最多的容器 {
    public static void main(String[] args) {

    }


    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }


}
