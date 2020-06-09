package com.yudianxx.basic.线程.可见性;

public class TestDemoSynchronized implements Runnable {

    private static volatile Integer s = 1; //能锁住
    private volatile Integer k = 1;
    private static Integer z = 1;
    private Integer y = 1;

    private void setNumeber() {
        s++;
    }

    private Integer getNumber() {
        return y;
    }


    @Override
    public void run() {
        synchronized (this) {
            int i = 50;
            while (i-- > 0) {
//        synchronized (i) {

//        synchronized (k) { //锁 k，i，其实就是锁对象，和 this一样，但是 j++不行，对象变了
//            y++;
//            i++; //这样可以，static 保持地址一样，同一个对象
                //这样可以，static 保持地址一样，如果不是同一个对象，volatile可以保证可见性
//        synchronized (this) {
//        synchronized (TestSynchronized5.class) {
//                setNumeber();
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //因为第一个同步代码块传入的this，所以两个同步代码所需要获得的对象锁都是同一个对象锁，对象锁需要等待
}

class TestDemo extends Thread {

    TestDemo(Runnable runnable, String name) {
        super(runnable, name);
    }

    public static void main(String[] args) {
        TestDemoSynchronized testDemoSynchronized = new TestDemoSynchronized();
//        TestDemoSynchronized testDemoSynchronized2 = new TestDemoSynchronized();

        TestDemo testDemo = new TestDemo(testDemoSynchronized, "Thread1");
        TestDemo testDemo2 = new TestDemo(testDemoSynchronized, "Thread2");
//        TestDemo testDemo3 = new TestDemo(testDemoSynchronized2, "Thread3");
        testDemo.start();
        testDemo2.start();
//        testDemo3.start();
    }
}

//详见文章吧