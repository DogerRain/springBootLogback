package com.yudianxx.basic.线程.可见性;

public class TestSynchronized5 implements Runnable {

    private static volatile Integer s = 1; //能锁住
    private volatile Integer k = 1;
    private static volatile Integer z = 1;
    private Integer y = 1;

    private void setNumeber() {
        y++;
    }

    @Override
    public void run() {
        int i = 50;
        while (i-- > 0) {
//        synchronized (i) {
//            synchronized (y) {
//        synchronized (k) { //锁 k，i，其实就是锁对象，和 this一样，但是 j++不行，对象变了
//            y++;
//            i++; //这样可以，static 保持地址一样，同一个对象
                //这样可以，static 保持地址一样，如果不是同一个对象，volatile可以保证可见性
//        synchronized (this) {
        synchronized (TestSynchronized5.class) {
                setNumeber();
                System.out.println(Thread.currentThread().getName() + " : " + i);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    //因为第一个同步代码块传入的this，所以两个同步代码所需要获得的对象锁都是同一个对象锁，对象锁需要等待
}

class RunnableTest extends Thread {

    RunnableTest(Runnable runnable, String name) {
        super(runnable, name);
    }

    public static void main(String[] args) {
        TestSynchronized5 testSynchronized5 = new TestSynchronized5();
        TestSynchronized5 testSynchronized6 = new TestSynchronized5();
        RunnableTest runnableTest = new RunnableTest(testSynchronized5, "Thread1");
//        RunnableTest runnableTest2 = new RunnableTest(testSynchronized5, "Thread2");
        RunnableTest runnableTest3 = new RunnableTest(testSynchronized6, "Thread3");
        runnableTest.start();
//        runnableTest2.start();
        runnableTest3.start();
    }

}

//详见文章吧