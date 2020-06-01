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

        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "---->>>>" + "jdk1.8以上可以用lambda语法");
        });
        t.start();

//        非lambda写法
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "---->>>>" +"不使用lambda写法");
            }
        });
        t2.start();


    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "---->>>>" +"继承Thread类");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---->>>>" +"实现Runable接口");
    }
}
