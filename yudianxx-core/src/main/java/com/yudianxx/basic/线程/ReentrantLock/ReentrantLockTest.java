package com.yudianxx.basic.线程.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangyongwen
 * @date 2021/2/4
 * @Description
 */
public class ReentrantLockTest implements Runnable {

    private Lock lock = new ReentrantLock();
    public int i = 0;


    public static void main(String[] args) {
        ReentrantLockTest reentrantLockDemo = new ReentrantLockTest();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(reentrantLockDemo, "thread" + i);
            thread.start();
        }
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i的总和：" + reentrantLockDemo.i);
    }

    @Override
    public void run() {
        lock.lock();
        for (int j = 0; j < 1000; j++) {
            i ++;
        }
        lock.unlock();
    }

    //
//    @Override
//    public void run() {
//        while (true) {
//            lock.lock(); // 获取锁
//            try {
//                if (tickets > 0) {
//                    TimeUnit.MILLISECONDS.sleep(100);
//                    System.out.println(Thread.currentThread().getName() + " " + tickets--);
//                } else {
//                    break;
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock(); // 释放锁
//            }
//        }
//    }
//    @Override
//    public void run() {
//        try {
//            boolean flag = lock.tryLock(1, TimeUnit.SECONDS);
//            if (flag) {
//                TimeUnit.MILLISECONDS.sleep(100);
//                System.out.println(Thread.currentThread().getName() + " " + tickets--);
//            } else {
//                System.out.println("没有抢到");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
}
