package com.yudianxx.interview.递归;

/**
 * @author huangyongwen
 * @date 2021/1/19
 * @Description
 */
public class 数组递归求和 {
    public int sum(int[] arr) {
        // 调用递归函数，初始从0开始
        return sum(0, arr);
    }

    // 递归函数
    private int sum(int begin, int[] arr) {
        // begin 表示从数组中哪个索引位置开始
        // 当begin == arr.length表示数组中没有剩余元素
        if (begin == arr.length) {
            return 0;
        }
        // 我只计算我拿到的数组中第一个元素的值
        // 和数组中剩余元素总和的和
        int result = arr[begin] + sum(begin + 1, arr);// 递归调用

        return result;
    }
}
