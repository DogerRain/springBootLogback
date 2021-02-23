package com.yudianxx.algorithm.大厂原题;

/**
 * @author huangyongwen
 * @date 2020/6/24
 * @Description
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段(m、n都是整数，n>1并且m>1)，
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问  可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 解析：
 * 其实是剪成3为乘数会得到最大的值
 *
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
