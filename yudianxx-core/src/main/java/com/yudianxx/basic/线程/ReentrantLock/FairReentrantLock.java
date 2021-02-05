package com.yudianxx.basic.线程.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangyongwen
 * @date 2021/2/4
 * @Description
 */
public class FairReentrantLock {
//    static Lock lock = new ReentrantLock(true);
    static Lock lock = new ReentrantLock(false);

    public static void main(String[] args) {
        myThreadDemo[] threadDemos = new myThreadDemo[10];
        for (int i = 0; i < 5; i++) {
            threadDemos[i] = new myThreadDemo(i);
        }
        for (int i = 0; i < 5; i++) {
            threadDemos[i].start();
        }
    }

    static class myThreadDemo extends Thread {
        int threadId;

        myThreadDemo(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1 * 100);
                for (int i = 0; i < 3; i++) {
                    lock.lock();
                    System.out.println("当前获得锁的线程--->>>" + threadId);
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
