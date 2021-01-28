package com.hac.常用类;

import java.util.Random;

/**
 * @author huangyongwen
 * @date 2021/1/26
 * @Description
 */
public class 随机数 {
    public static void main(String[] args) {
        Random randSeed = new Random(47);
        for (int i = 0; i < 10; i++)
            System.out.print(randSeed.nextInt(100) + " ");

        System.out.println();
        Random randNoSeed = new Random();
        for (int i = 0; i < 10; i++)
            System.out.print(randNoSeed.nextInt(100)+" ");

    }
}
