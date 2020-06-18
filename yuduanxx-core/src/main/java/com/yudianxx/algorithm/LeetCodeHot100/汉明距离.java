package com.yudianxx.algorithm.LeetCodeHot100;

public class 汉明距离 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(2,9));
        System.out.println(Integer.toBinaryString(3^9));
    }

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
