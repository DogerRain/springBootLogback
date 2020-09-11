package com.yudianxx.interview.递归;

/**
 * @author huangyongwen
 * @date 2020/9/11
 * @Description
 */
public class 递归 {

     int a =1;

    public static void main(String[] args) {
        split(12);
    }

    public static int split(int number) {
        int j =1;
        if (number > 1) {
            if (number % 2 != 0) {
                System.out.println(split((number + 1) / 2));
            }
            System.out.println(split(number / 2));
        }
        return number;
    }

    public  final void aa(){
        System.out.println(a);
    }
}
