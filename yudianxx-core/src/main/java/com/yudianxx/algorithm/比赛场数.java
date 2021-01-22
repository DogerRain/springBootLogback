package com.yudianxx.algorithm;

/**
 * @author huangyongwen
 * @date 2021/1/20
 * @Description
 */
public class 比赛场数 {
    public static void main(String[] args) {
        System.out.println(gameCount(26));
        System.out.println(gameCount2(26));
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

    static int gameCount2(int players) {
        int count = 0;
        if (players == 1) {
            return 0;
        }
        int result = players % 2;
        int gameCount = players / 2;
        count = count + gameCount;
        players = result > 0 ? players / 2 + 1 : players / 2;
        return count + gameCount2(players);
    }

}
