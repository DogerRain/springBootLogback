package com.yudianxx.basic.线程.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangyongwen
 * @date 2021/2/7
 * @Description
 */
public class ConditionTest {
    static ReentrantLock lock = new ReentrantLock();
    //通过ReentrantLock创建Condition实例，并与之关联
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程执行ing...");
        new Thread(new AwaitThread()).start();
        try {
            Thread.sleep(2000);
            lock.lock();
            condition.signal();
        } finally {
            lock.unlock();
        }
        System.out.println("主线程执行结束");
    }

    static class AwaitThread implements Runnable {
        @Override
        public void run() {

            System.out.println("子线程执行ing...");
            lock.lock();
            try {
                System.out.println("子线程停止了");
                condition.await();
                System.out.println("子线程恢复执行了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
