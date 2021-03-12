package com.yudianxx.algorithm;

/**
 * @author huangyongwen
 * @date 2021/3/11
 * @Description 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 比特位计数338 {
    public static void main(String[] args) {
        int[] result = countBits2(7);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();


    }

    /**
     * 规律
     * 0    0
     * 1    1
     * 2    1
     * 3    2
     * 4    1
     * 5    2
     * 6    2
     * 7    3
     * 8    1
     * 9    2
     *
     * 规律，通过奇偶数判断
     *
     * @param num
     * @return
     */
    static int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = result[i / 2];
            }
        }
        return result;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 动态规划
     *
     * @param n
     * @return
     */
    static int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        // ans[i] = 「i >> 1 所包含的 1 的个数」+「i 的最低位是否为 1」
        for (int i = 1; i <= n; i++) {
            //因为ans[i>>1]肯定存在的
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }


}
