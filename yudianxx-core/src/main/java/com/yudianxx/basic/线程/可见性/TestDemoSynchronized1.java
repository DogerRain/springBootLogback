package com.yudianxx.basic.线程.可见性;

public class TestDemoSynchronized1 implements Runnable {

    private static volatile Integer s = 1; //能锁住
    private volatile Integer k = 1;
    private static Integer z = 1;

    private Integer y = 0;

    private void setNumeber() {
//        int num = getNumber();
//        int count = 1;
//        num = num + count;
//        y = num;
        y++;
    }

    private Integer getNumber() {
        return y;
    }

    @Override
    public void run() {

        int i = 50;
        while (i-- > 0) {
            synchronized (y) {
                y++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + i + "  --->>>" + y);
            }
        }
    }

    //因为第一个同步代码块传入的this，所以两个同步代码所需要获得的对象锁都是同一个对象锁，对象锁需要等待
}

class TestDemo1 extends Thread {

    TestDemo1(Runnable runnable, String name) {
        super(runnable, name);
    }

    public static void main(String[] args) {
        TestDemoSynchronized testDemoSynchronizedfor = new TestDemoSynchronized();
        for (int i = 1; i <= 2; i++) {
            TestDemo testDemofor = new TestDemo(testDemoSynchronizedfor, "Thread" + i);
            testDemofor.start();
        }
    }
}

//详见文章吧