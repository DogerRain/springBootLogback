package com.yudianxx.basic.线程.可见性;

// class ThreadDemo extends Thread {
//
//    int i = 1;
//
//    @Override
//    public void run() {
//        super.run();
//        for (; i <= 50; i++) {
//            System.out.println(Thread.currentThread().getName() + "-->>" + i);
//        }
//    }
//
//}

/**
 * 理解一下
 */

class ThreadA extends Thread {
    int j = 1;
    private volatile static Integer i = 1;
    private volatile static Integer k = 1;
    Integer l = 1;

    @Override
    public void run() {
        //搞清楚，锁对象和锁类的区别
//        synchronized (ThreadA.class) {
//        synchronized (this) {
//        synchronized (i) { //i++，i对象变了，锁失效;i++不是原子操作
        synchronized (this.l) {
            for (; i <= 110; i++, j++) {
                System.out.println(j + "--->>" + Thread.currentThread().getName() + "-->>" + i);
            }
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        new Thread(threadA,"ThreadA").start();
        new Thread(threadA,"ThreadB").start();
    }
}
