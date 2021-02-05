package com.yudianxx.basic.线程.可见性;

/**
 * @author huangyongwen
 * @date 2021/2/4
 * @Description
 */
public class TestDemoSynchronized0 implements Runnable {
    private Integer y = 0;

    private void setNumber() {
        y++;
    }

    private int getNumber() {
        return y;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setNumber();
            System.out.println(Thread.currentThread().getName() + " : " + i + "  --->>>" + getNumber());
        }
    }
}

class MyTestDemo extends Thread {
    MyTestDemo(Runnable runnable, String name) {
        super(runnable, name);
    }

    public static void main(String[] args) {
        TestDemoSynchronized0 testDemoSynchronized0 = new TestDemoSynchronized0();
        for (int i = 1; i <= 2; i++) {
            MyTestDemo myTestDemo = new MyTestDemo(testDemoSynchronized0, "Thread" + i);
            myTestDemo.start();
        }
    }
}
