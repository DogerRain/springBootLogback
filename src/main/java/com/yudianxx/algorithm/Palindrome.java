package com.yudianxx.algorithm;


public class Palindrome {


/**
 * @Author: Administrator
 * @Date: 2019/10/11  11:13
 * @Description: 回文
 * @Param:
 * @return:
 */
    public static void main(String[] args) {
        int inputStr = 12321;
        System.out.println(new Palindrome().ifPalindrome(inputStr));
    }

    private boolean ifPalindrome(int x) {
        String str = String.valueOf(x);
        int length = str.length();
        for (int i = 0; i < (length / 2); i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
