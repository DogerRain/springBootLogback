package com.yudianxx.basic.线程.volatile作用;

/**
 * @author huangyongwen
 * @date 2020/6/23
 * @Description
 */

public class VolatileTest extends Thread {

    public volatile static int count = 0;
    //    public static int count = 0;
//    public int count = 0;
    public static int count2 = 0;
    public static Counter counter = new Counter();
    public volatile static Integer j = 1;


    public static void main(String[] args) {
        //100个线程去访问
        VolatileTest[] mythreadArray = new VolatileTest[100];
        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new VolatileTest();
        }
        for (int i = 0; i < 100; i++) {
            mythreadArray[i].start();
        }

        System.out.println(Thread.currentThread().getName() + " count  =" + count);
        System.out.println(Thread.currentThread().getName() + " count2 =" + counter.getCount());
    }

    private void addCount() {
//        synchronized (this.j) {
//        synchronized (this) {
//        synchronized (VolatileTest.class) {
        for (int i = 0; i < 100; i++) {
            count++;
//                System.out.println(Thread.currentThread().getName() + " count=" + count);
            counter.getCount();
        }

    }
//        System.out.println(Thread.currentThread().getName() + " count=" + count);
//    }

    @Override
    public void run() {
        addCount();

    }
}

class Counter {
    private int count = 0;

    public synchronized int getCount() {
        return count++;
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

