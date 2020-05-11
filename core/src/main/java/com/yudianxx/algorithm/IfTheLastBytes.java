package com.yudianxx.algorithm;

public class IfTheLastBytes {
    public static void main(String[] args) {
        int[] inputString = {0, 0, 1, 1, 0};
//        int[] inputString = {1, 0};
        System.out.println(new IfTheLastBytes().IfTheLastCharABytes(inputString));
    }

    public boolean IfTheLastCharABytes(int[] bits) {
        for (int i = 0; i < bits.length; ) {
            if (bits[i] == 1) {
                i = i + 2;
            } else {
                if (i == bits.length - 1) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
