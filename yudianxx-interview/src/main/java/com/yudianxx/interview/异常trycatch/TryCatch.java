package com.yudianxx.interview.异常trycatch;

/**
 * @author huangyongwen
 * @date 2020/7/1
 * @Description
 */
public class TryCatch {
    private static boolean pdd;

    String a = "1";

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(pdd);
    }

    public static int test() {
        int num = 5;
        try {
            num = 6;
            return num;
        } catch (Exception e) {
            num = 7;
            return 10;
        } finally {
            num = 15;
        }
    }

    public void loop() {
        int i = 10;

        while (i < 0) {
            i--;
        }
    }

}
