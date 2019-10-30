package com.yudianxx.basic.线程;


/**
 * Created by lkmc2 on 2018/1/27.
 */
class MyThread1 implements Runnable {
    private String objName;
    private MyThread1 lockObj; //用来持有对方的对象

    public MyThread1(String objName) {
        this.objName = objName;
    }

    public void setLockObj(MyThread1 lockObj) {
        this.lockObj = lockObj;
    }

    public synchronized void intoB() {
        String currentThread = Thread.currentThread().getName();
        System.out.printf("线程%s进入intoB，objName=%s\n", currentThread, objName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException x) {
        }
        System.out.printf("线程%s尝试进入intoA，objName=%s\n", currentThread, objName);
        lockObj.intoA();
        System.out.printf("线程%s离开intoB()，objName=%s\n", currentThread, objName);
    }

    public synchronized void intoA() {
        String currentThread = Thread.currentThread().getName();
        System.out.printf("线程%s进入intoA，objName=%s\n", currentThread, objName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException x) {
        }
        System.out.printf("线程%s尝试进入intoB，objName=%s\n", currentThread, objName);
        lockObj.intoB();
        System.out.printf("线程%s离开intoA()，objName=%s\n", currentThread, objName);
    }

    @Override
    public void run() {
        if (objName.equals("A")) {
            intoA();
        } else {
            intoB();
        }
    }
}

public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        final MyThread1 obj1 = new MyThread1("A");
        final MyThread1 obj2 = new MyThread1("B");

        obj1.setLockObj(obj2); //持有对方的对象
        obj2.setLockObj(obj1);

        Thread threadA = new Thread(obj1, "threadA");
        threadA.start();

        Thread.sleep(200);

        Thread threadB = new Thread(obj2, "threadB");
        threadB.start();
    }
}