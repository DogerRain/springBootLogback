package com.yudianxx.basic.线程.ThreadDemo;

/**
 * @author huangyongwen
 * @date 2019/12/17
 * @Description
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();

        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();

        Thread t = new Thread(()->{
            System.out.println("jdk1.8以上可以用lambda语法");
        });
        t.start();
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("继承Thread类");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("实现Runable接口");
    }
}
