package com.yudianxx.basic.线程;

import java.util.concurrent.TimeUnit;

class SynchronizedDeadLock implements Runnable {
    private String lockA;
    private String lockB;

    public SynchronizedDeadLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获得：" + lockB);
            //至关重要是这个sleep，因为这里睡眠是为了让 第二个线程有机会进来
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockB + "\t 尝试获得：" + lockA);
            }
        }
    }
}

/**
 * @author: mulming
 * @ClassName: DeadLockDemo
 * @date: 2019年5月13日 上午9:59:55
 * @Description:必须产生死锁的代码
 */
public class DeadLockDemo {

    public static void main(String[] args) throws InterruptedException {
        String lockA = "locka";
        String lockB = "lockb";
        new Thread(new SynchronizedDeadLock(lockA, lockB), "Thread1").start();
//        Thread.sleep(2*1000);
        new Thread(new SynchronizedDeadLock(lockB, lockA), "Thread2").start();
    }
}

