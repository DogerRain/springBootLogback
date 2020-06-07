package com.yudianxx.basic.线程.可见性;

public class TestSynchronized2

//    代码块和类锁的修饰（静态）方法：
{
    public void test1() {
        synchronized (TestSynchronized2.class) {
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

    public static synchronized void test2() {
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
        final TestSynchronized2 myt2 = new TestSynchronized2();
        Thread test1 = new Thread(new Runnable() {
            public void run() {
                myt2.test1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                TestSynchronized2.test2();
            }
        }, "test2");
        test1.start();
        test2.start();
    }

//    其实，类锁修饰方法和代码块的效果和对象锁是一样的，因为类锁只是一个抽象出来的概念，
//    只是为了区别静态方法的特点，因为静态方法是所有对象实例共用的，所以对应着synchronized修饰的静态方法的锁也是唯一的，
//    所以抽象出来个类锁
}