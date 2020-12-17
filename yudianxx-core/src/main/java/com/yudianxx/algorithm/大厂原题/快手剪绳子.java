package com.yudianxx.algorithm.大厂原题;

/**
 * @author huangyongwen
 * @date 2020/6/24
 * @Description
 */
public class 快手剪绳子 {

    public static void main(String[] args) {

        System.out.println(cuttingRope(4));
        System.out.println(cuttingRope(6));
        System.out.println(cuttingRope(8));
        System.out.println(cuttingRope(9));
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope(11));

    }

    /**
     * 这是我的方法
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int NumOf3 = n / 3;
        if (n - NumOf3 * 3 == 1) {
            NumOf3--;
        }

//        int NumOf2 = (n - NumOf3 * 3) / 2;

//        return (int)Math.pow(3, NumOf3) * (int)Math.pow(2, NumOf2);

        return (int) Math.pow(3, NumOf3) * ((n - NumOf3 * 3) == 0 ? 1 : (n - NumOf3 * 3));

    }

    /**
     * O(n)
     *
     * @param n
     * @return
     */
    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (0 == b) {
            return (int) Math.pow(3, a);
        } else if (1 == b) {
            return (int) Math.pow(3, a - 1) * 4;
        } else {
            return (int) Math.pow(3, a) * 2;
        }
    }

    /**
     *
     * 贪心算法   O(1)
     *
     * @param n
     * @return
     */
    public int cuttingRope3(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int NumOf3 = n / 3;
        if (n - NumOf3 * 3 == 1) {
            NumOf3--;
        }

        int NumOf2 = (n - NumOf3 * 3) / 2;

        return (int) Math.pow(3, NumOf3) * (int) Math.pow(2, NumOf2);
    }
}
