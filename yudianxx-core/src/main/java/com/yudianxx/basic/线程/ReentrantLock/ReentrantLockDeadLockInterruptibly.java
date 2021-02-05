package com.yudianxx.basic.线程.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangyongwen
 * @date 2021/2/5
 * @Description
 */
public class ReentrantLockDeadLockInterruptibly {
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new DeadLockDemo(lock1, lock2), "Thread1");
        Thread thread2 = new Thread(new DeadLockDemo(lock2, lock1), "Thread2");
        thread1.start();
        thread2.start();

        Thread.sleep(5 * 1000);
        if (Thread.activeCount() >= 4) {
            thread1.interrupt();//是第一个线程中断
        }
    }

    static class DeadLockDemo implements Runnable {
        Lock lockA;
        Lock lockB;

        public DeadLockDemo(Lock lockA, Lock lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }

        @Override
        public void run() {
            try {
                lockA.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获得：" + lockB);
                TimeUnit.SECONDS.sleep(2);
                lockB.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockB + "\t 尝试获得：" + lockA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockA.unlock();
                lockB.unlock();
                System.out.println(Thread.currentThread().getName() + "正常结束!");
            }
        }
    }
}


