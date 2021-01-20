package com.yudianxx.algorithm;

/**
 * @author huangyongwen
 * @date 2021/1/20
 * @Description
 */
public class 比赛场数 {
    public static void main(String[] args) {
        System.out.println(gameCount(7));
    }

    static int gameCount(int players) {
        int count = 0;
        while (players > 1) {
            int result = players % 2;
            int gameCount = players / 2;
            players = result > 0 ? players / 2 + 1 : players / 2;
            count = count + gameCount;
        }
        return count;
    }

}
