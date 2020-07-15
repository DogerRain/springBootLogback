package com.yudianxx.basic.线程.奇怪的线程;

public class Threads4 {
    public static void main(String[] args) {
        new Threads4().go();

    }

    public void go(){

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };

        Thread t = new Thread(r);
        t.start();
    }
}
