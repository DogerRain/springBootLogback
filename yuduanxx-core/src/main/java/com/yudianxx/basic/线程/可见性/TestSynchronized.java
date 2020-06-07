package com.yudianxx.basic.线程.可见性;

public class TestSynchronized {
    //对象锁 以下两个其实都是对象锁
//    public synchronized void test1() {
//        int i = 5;
//        while (i-- > 0) {
//            System.out.println(Thread.currentThread().getName() + " : " + i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ie) {
//            }
//        }
//    }

    public  void test1() {
        synchronized (this){
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ie) {
                }
            }
        }
    }


    public  void test2() {
        synchronized(TestSynchronized.class){
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
        final TestSynchronized myt2 = new TestSynchronized();
        Thread test1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myt2.test1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myt2.test2();
            }
        }, "test2");
        test1.start();
        test2.start();
    }

//    线程获得对象锁的同时，也可以获得该类锁，即同时获得两个锁，这是允许的。
//    参考 TestSynchronized2 也是一样的道理，静态代码块（方法）其实也是一个类锁，因为 可以被全局访问
//   两个线程都可以获得锁
//    test2 : 4
//    test1 : 4
//    test1 : 3
//    test2 : 3
//    test2 : 2
//    test1 : 2
//    test1 : 1
//    test2 : 1
//    test1 : 0
//    test2 : 0

}