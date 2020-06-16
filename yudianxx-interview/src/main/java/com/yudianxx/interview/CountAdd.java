package com.yudianxx.interview;

public class CountAdd {


    public static void main(String[] args) {
        int count = 0;
        int num = 0;
        for (int i = 1; i <= 10; i++) {
            count = count++;
            num = num + i;
        }
        System.out.println("count=" + count + ",num=" + num);
    }


}
