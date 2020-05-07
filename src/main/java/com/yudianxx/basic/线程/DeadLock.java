package com.yudianxx.basic.线程;

/**
 * 这个例子不能死锁！！！！！不能死锁
 */

public class DeadLock {
    public static String a = "a";
    public static String b = "b";

    public static void main(String[] args) {
        Thread lock1 = new Thread(new Lock1());
        Thread lock2 = new Thread(new Lock2());
        lock1.start();
        lock2.start();
    }
}

class Lock1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Lock 1 is running");
        try {
            while (true){
                synchronized (DeadLock.a){
                    System.out.println("Lock1 lock a ");
                }
                Thread.sleep(5000);
                synchronized (DeadLock.b){
                    System.out.println("Lock1 lock b");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Lock2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Lock 2 is running");
        try {
            while (true){
                synchronized (DeadLock.b){
                    System.out.println("Lock2 lock b ");
                }
                Thread.sleep(2000);
                synchronized (DeadLock.a){
                    System.out.println("Lock2 lock a");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}