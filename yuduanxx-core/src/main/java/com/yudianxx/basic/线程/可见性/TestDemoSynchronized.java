package com.yudianxx.basic.线程.可见性;

public class TestDemoSynchronized implements Runnable {
    public Integer y = 0;
    public Integer x = new Integer(1);
    public Integer z = 200;
    public Integer k = 100;


    public void setNumber() {
        y++;
    }

    public int getNumber() {
        return y;
    }

    @Override
    public void run() {
        synchronized (TestDemoSynchronized.class) {
//        synchronized (this) { //不能
//        synchronized (x) {  //不能，x 在堆， 1 在常量池，两个对象拥有的x 不一样，可以进入
//        synchronized (z) {  //不能 //-128-127 之间，还是同一个对象，否则会Intger创建一个新对象
//        synchronized (k) { //能，x 此时在常量池，常量池是线程共享的，
            for (int i = 1; i <= 5; i++) {
                setNumber();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + i + "  --->>> " + getNumber());
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
        TestDemoSynchronized testDemoSynchronizedfor2 = new TestDemoSynchronized();
       /* for (int i = 1; i <= 2; i++) {
            TestDemo testDemofor = new TestDemo(testDemoSynchronizedfor, "Thread" + i);
            testDemofor.start();
        }*/
        TestDemo testDemo = new TestDemo(testDemoSynchronizedfor, "Thread1");
        TestDemo testDemo2 = new TestDemo(testDemoSynchronizedfor2, "Thread2");

        testDemo.start();
        testDemo2.start();

    }
}