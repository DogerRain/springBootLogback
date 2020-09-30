package com.yudianxx.interview.异常trycatch;

/**
 * @author huangyongwen
 * @date 2020/9/30
 * @Description
 */
public class TryCatch顺序 {
    public static void main(String[] args) {
        System.out.println(test2());
    }

    public static int test2() {
        int b = 20;
        try {
            System.out.println("try block");
            return b;
        } catch (Exception e) {
            b = 50;
            System.out.println("catch block");
        } finally {
            b = 100;
            System.out.println("finally block");
        }
        return b;
    }
}
