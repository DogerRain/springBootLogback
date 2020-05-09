package com.yudianxx.basic.线程.Synchronized;

/**
 * @author huangyongwen
 * @date 2020/5/8
 * @Description
 */
public class SynchronizedTest extends Thread {
    private int threadNo;

    public SynchronizedTest(int threadNo) {
        this.threadNo = threadNo;
    }

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            new SynchronizedTest(i).start();
            Thread.sleep(1);
        }
    }

    /**
     * 对于一个成员方法加synchronized关键字，这实际上是以这个成员方法所在的对象本身作为对象锁。,这里加不加synchronized结果都是随机的
     */
    @Override
    public synchronized void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println("No." + threadNo + ":" + i);
        }
    }
}


class SynchronizedTest2 extends Thread {
    private int threadNo;
    private String lock;

    public SynchronizedTest2(int threadNo, String lock) {
        this.threadNo = threadNo;
        this.lock = lock;
    }


    /**
     * 程序通过在main方法启动10个线程之前，创建了一个String类型的对象。并通过ThreadTest2的构造函数，
     * 将这个对象赋值 给每一个ThreadTest2线程对象中的私有变量lock。根据Java方法的传值特点，我们知道，
     * 这些线程的lock变量实际上指向的是堆内存中的 同一个区域，即存放main函数中的lock变量的区域。
     * <p>
     * 简单说就是一个线程拿到了一个对象的锁
     */

    public static void main(String[] args) throws Exception {
        String lock = new String("lock");
        for (int i = 1; i <= 10; i++) {
            new SynchronizedTest2(i, lock).start();
            Thread.sleep(1);
        }
    }

    @Override
    public void run() {
        //lock是在堆中的实例变量
        synchronized (lock) {
            for (int i = 1; i <= 1000; i++) {
                System.out.println("No." + threadNo + ":" + i);
            }
        }
    }
}


class SynchronizedTest3 extends Thread {

    private int threadNo;

    public SynchronizedTest3(int threadNo) {
        this.threadNo = threadNo;
    }

    public static void main(String[] args) throws Exception {

        for (int i = 1; i <= 10; i++) {
            new SynchronizedTest3(i).start();
            Thread.sleep(1);
        }
    }

    /**
     *
     * 对象锁就是该静态放发所在的类的Class实例，由于在JVM中，所有被加载的类都有唯一的类对象，
     * 具体到本例，就是唯一的 SynchronizedTest3.class 整个对象。不管我们创建了该类的多少实例，但是它的类实例仍然是一个
     */


    //静态变量、方法 都在方法区
    public  synchronized void abc(int threadNo) {
        for (int i = 1; i <= 1000; i++) {
            System.out.println("No." + threadNo + ":" + i);
        }
    }

    public void run() {
        abc(threadNo);
    }


    /**
     * 第一种情况，对象锁即为每一个线程对象，因此有多个，所以同步失效，
     * 第二种共用同一个对象锁lock，因此同步生效，
     * 第三个因为是static因此对象锁为ThreadTest3的class 对象，因此同步生效。
     */


}