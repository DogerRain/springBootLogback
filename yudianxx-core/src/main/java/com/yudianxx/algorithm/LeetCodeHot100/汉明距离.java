package com.yudianxx.algorithm.LeetCodeHot100;


/*
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 231.

示例:

输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hamming-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 汉明距离 {
    public static void main(String[] args) {
       /* System.out.println(hammingDistance(1, 4));
        System.out.println(Integer.bitCount(31));
        System.out.println(1 ^ 4);
        System.out.println(1 ^ 19);*/
        System.out.println(hammingDistance1(19, 127));
        System.out.println(hammingDistance(19, 127));

    }

    public static int hammingDistance(int x, int y) {
        // bitCount 简单的来说就是计算这个数的二进制有多少个 1
        return Integer.bitCount(x ^ y);

    }

    public static int hammingDistance1(int x, int y) {
        //异或，位相同则为0，不相同则为1 ，最后返回是一个十进制的数
        int result = x ^ y;
        int instances = 0;

        do {
            if (result % 2 == 1) {
                instances++;
            }
        } while ((result = result >> 1) != 0);

        return instances;

    }

    /**
     * 答案题解
     *
     * @param x
     * @param y
     * @return
     */
    static int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1){
                distance += 1;
            }
            xor = xor >> 1;
        }
        return distance;
    }

}
