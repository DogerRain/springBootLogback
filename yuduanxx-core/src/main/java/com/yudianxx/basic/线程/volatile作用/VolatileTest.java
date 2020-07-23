package com.yudianxx.basic.线程.volatile作用;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HaC
 * @date 2020/6/23
 * @Description
 */

public class VolatileTest extends Thread {
    public static Counter1 counter1 = new Counter1();
    public static Counter2 counter2 = new Counter2();
    public static Counter3 counter3 = new Counter3();
    public static Counter4 counter4 = new Counter4();

    public static void main(String[] args) {
        //100个线程去访问
        VolatileTest[] mythreadArray = new VolatileTest[100];
        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new VolatileTest();
        }

        for (int i = 0; i < 100; i++) {
            mythreadArray[i].start();
        }

        while (Thread.activeCount() > 4) //主线程和守护线程，只剩下主线程和守护线程 就退出。
            Thread.yield();
        //保证执行完毕，如果无法理解上面的，可以设置休眠时间
    /*    try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(Thread.currentThread().getName() + " counter1 =" + counter1.getCount());
        System.out.println(Thread.currentThread().getName() + " counter2 =" + counter2.getCount());
        System.out.println(Thread.currentThread().getName() + " counter3 =" + counter3.getCount());
        System.out.println(Thread.currentThread().getName() + " counter4 =" + counter4.getCount());

    }

    private void addCount() {
        for (int i = 0; i < 100; i++) {
//            synchronized (VolatileTest.class) {
            counter1.setCount();
//            }
            counter2.setCount();
            counter3.setCount();
            counter4.setCount();
        }
    }

    @Override
    public void run() {
        addCount();
    }

    public static class Counter1 {
        private volatile int count = 0;

        public void setCount() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    //synchronized 锁等待
    public static class Counter2 {
        private int count = 0;

        public synchronized void setCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

    }

    //Lock
    public static class Counter3 {
        private int count = 0;
        Lock lock = new ReentrantLock();

        public void setCount() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }

        public int getCount() {
            return count;
        }
    }

    //java并发包中的原子操作类，原子操作类是通过CAS循环的方式来保证其原子性的
    public static class Counter4 {
        private AtomicInteger count = new AtomicInteger();

        public void setCount() {
            count.getAndIncrement();
        }

        public AtomicInteger getCount() {
            return count;
        }
    }
}


/**
 * 100个线程分别执行100次 count++
 * 期望结果应该是 100*100 = 10000
 * 但是最后的结果并不是这样的
 * 因为 volatile修饰的变量并不保证对它的操作（自增）具有原子性。
 * <p>
 * 假设 i 自增到 5，线程A从主内存中读取i，值为5，将它存储到自己的线程空间中，执行加1操作，值为6。此时，CPU切换到线程B执行，
 * 从主从内存中读取变量i的值。由于线程A还没有来得及将加1后的结果写回到主内存，线程B就已经从主内存中读取了i，因此，线程B读到的变量 i 值还是5
 * <p>
 * 这种情形在《Effective JAVA》中称之为“安全性失败”
 */

