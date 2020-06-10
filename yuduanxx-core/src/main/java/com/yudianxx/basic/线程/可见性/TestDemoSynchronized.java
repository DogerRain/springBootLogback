package com.yudianxx.basic.线程.可见性;

public class TestDemoSynchronized implements Runnable {
    private Integer y = 0;

    private void setNumber() {
        y++;
    }

    private int getNumber() {
        return y;
    }

    @Override
    public void run() {
        synchronized (TestDemoSynchronized.class) {
            for (int i = 1; i <= 5; i++) {
                setNumber();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + i + "  --->>>" + getNumber());
            }
        }
    }
}

class TestDemo extends Thread {
    TestDemo(Runnable runnable, String name) {
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