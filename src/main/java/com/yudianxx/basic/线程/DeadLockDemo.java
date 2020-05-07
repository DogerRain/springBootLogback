package com.yudianxx.basic.线程;

import java.util.concurrent.TimeUnit;
class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockA+"\t 尝试获得："+lockB);
            try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockB+"\t 尝试获得："+lockA);
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

    public static void main(String[] args) {
        String lockA="locka";
        String lockB="lockb";
        new Thread(new HoldLockThread(lockA, lockB),"ThrAAA").start();
        new Thread(new HoldLockThread(lockB, lockA),"ThrBBB").start();
    }
}

