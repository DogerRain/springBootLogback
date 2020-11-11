package com.yudianxx.algorithm.其他;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangyongwen
 * @date 2020/11/4
 * @Description
 */

//原文链接：https://mp.weixin.qq.com/s/fM4gEFnL0RJMuMhoVxvEtQ

/*
* 1. 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
2. 两个线程交替打印 0~100 的奇偶数
3. 通过 N 个线程顺序循环打印从 0 至 100
4. 多线程按顺序调用，A->B->C，AA 打印 5 次，BB 打印10 次，CC 打印 15 次，重复 10 次
5. 用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C4D...26Z
*
* */
public class 多线程顺序 {
    public static void main(String[] args) {

    }

    static class Item1 {
        private int times;//控制打印次数
        private int flag;//信号值， 0表示打印A，1表示打印B，2表示打印C。
        private int count;
        private Lock lock = new ReentrantLock();

        Item1(int times) {
            this.times = times;
        }

        //打印方法
        private void print(String name, int target) {
            for (int i = 0; i < times; ) {
                lock.lock();
                System.out.println("进入sleep:"+ ++count);
                if (flag % 3 == target) {
                    System.out.println(name);
                    i++;
                    flag++;
                }
                lock.unlock();
            }
        }

        public static void main(String[] args) {
            Item1 item1 = new Item1(1);
            new Thread(() -> {
                item1.print("C", 2);
            }).start();
            new Thread(() -> {
                item1.print("A", 0);
            }).start();
//            try {
//                Thread.sleep(1*1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            new Thread(() -> {
                item1.print("B", 1);
            }).start();


        }

    }


}
