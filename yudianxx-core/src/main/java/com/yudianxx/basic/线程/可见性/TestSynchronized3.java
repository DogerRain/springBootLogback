package com.yudianxx.basic.线程.可见性;

public class TestSynchronized3 {
    public void test1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final TestSynchronized3 myt2 = new TestSynchronized3();
        Thread test1 = new Thread(new Runnable() {
            public void run() {
                myt2.test1();

            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                myt2.test2();
            }
        }, "test2");
        test1.start();
        test2.start();
    }

    //因为第一个同步代码块传入的this，所以两个同步代码所需要获得的对象锁都是同一个对象锁，对象锁需要等待
}

