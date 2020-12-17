package com.yudianxx.basic.线程.守护线程;

/**
 * @author huangyongwen
 * @date 2020/7/22
 * @Description
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread daemonThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 子线程执行中....");
                        Thread.sleep(1 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(Thread.currentThread().getName() + " finally 语句块");
                    }
                }

            }
        }, "daemonThread1");

        Thread daemonThread2 = new Thread(new Runnable() {
            int i = 2;

            @Override
            public void run() {
                while (i-- > 0) {
                    System.out.println(Thread.currentThread().getName() + " 子线程执行中....");
                }
            }
        }, "daemonThread2");

        daemonThread1.setDaemon(true); //daemon要先于start前执行，否则会报  IllegalThreadStateException
        daemonThread1.start();
//        daemonThread2.start();
        System.out.println("isDaemon=" + daemonThread1.isDaemon());
//        try {
//            Thread.sleep(2 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("daemonThread1 状态"+daemonThread1.isAlive());
//        System.out.println("daemonThread2 状态"+daemonThread2.isAlive());

    }
}

class Test extends Thread {
    public Test() {

    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(i);
        }

    }

    public static void main(String args[]) throws InterruptedException {
        Test test = new Test();
        test.setDaemon(true);
        test.start();
        sleep(2 * 1000);
        System.out.println("isDaemon=" + test.isDaemon());
    }
}