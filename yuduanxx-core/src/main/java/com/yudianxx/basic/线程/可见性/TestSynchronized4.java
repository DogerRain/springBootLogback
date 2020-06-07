package com.yudianxx.basic.线程.可见性;

public class TestSynchronized4 {
    public void test1() {
        synchronized (TestSynchronized4.class) {
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

    public void test2() {
        synchronized (TestSynchronized4.class) {
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

    public static void main(String[] args) {
        final TestSynchronized4 myt2 = new TestSynchronized4();
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
}