package com.yudianxx.basic.线程.join;

/**
 * @author huangyongwen
 * @date 2020/7/21
 * @Description
 */
public class ThreadMethodTest {
    public static void main(String[] args) throws InterruptedException {

        final Object object = new Object();

        ThreadMethodTest.MyThread myThread1 = new ThreadMethodTest.MyThread("Thread 1", object);

        MyThread myThread2 = new MyThread("Thread 2", object);

 /*       myThread1.start();
        myThread1.wait();

        myThread2.start();
        myThread2.join();*/

        myThread1.start();
        myThread1.setPriority(10);
        myThread2.start();

        if (!myThread1.isAlive()) {
            myThread1.interrupt();
        }

//        System.out.println(Thread.currentThread().getName() + " 线程正在运行");
    }

    static class MyThread extends Thread {
        Object object;
        String name;

        MyThread(String name, Object object) {
            super(name);
            this.name = name;
            this.object = object;
        }

        @Override
        public void run() {
            testSleepLock();
//        testWaitLock();
        }

        void testSleepLock() {
            try {
                System.out.println("当前线程：" + Thread.currentThread().getName());
                if (name.equals("Thread 1")) {
                    synchronized (object) {
                        Thread.sleep(5 * 1000);

                        System.out.println(Thread.currentThread().getName() + " sleep 结束，释放锁");
                    }

                } else {
                    synchronized (object) {
                        System.out.println(Thread.currentThread().getName() + " 拿到锁");

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void testWaitLock() {
            System.out.println("当前线程：" + Thread.currentThread().getName());
            if (name.equals("Thread 1")) {
                synchronized (object) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " wait 结束");
                }
            } else {
                synchronized (object) {
                    object.notify(); //唤醒不一定马上执行
                    System.out.println(Thread.currentThread().getName() + " 拿到锁");
                }
            }
        }


    }



}