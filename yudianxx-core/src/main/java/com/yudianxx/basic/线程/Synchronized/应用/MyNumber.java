package com.yudianxx.basic.线程.Synchronized.应用;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangyongwen
 * @date 2020/11/4
 * @Description
 */
@Data
public class MyNumber {

    private int val;

    public MyNumber(int val) {
        this.val = val;
    }


    public synchronized void increase() {
        val++;
        notify(); //数据变了，唤醒另外的线程
    }

    public synchronized void waitToOld() {
        while ((val % 2) == 0) {
            try {
                System.out.println("i am " + Thread.currentThread().getName() + " ,but now is even:" + val + ",so wait");
                wait(); //只要是偶数，一直等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void waitToEven() {
        while ((val % 2) != 0) {
            try {
                System.out.println("i am " + Thread.currentThread().getName() + "  ,but now old:" + val + ",so wait");
                wait(); //只要是奇数，一直等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class SingleNumber implements Runnable {
        private MyNumber myNumber;

        SingleNumber(MyNumber myNumber) {
            this.myNumber = myNumber;
        }

        @Override
        public void run() {
            while (true) {
                myNumber.waitToOld();  //等待数据变成奇数
                System.out.println("old:" + myNumber.getVal());
                myNumber.increase();
                if (myNumber.getVal() > 98) {
                    break;
                }
            }
        }

    }

    static class DoubleNumber implements Runnable {
        private MyNumber myNumber;

        DoubleNumber(MyNumber myNumber) {
            this.myNumber = myNumber;
        }

        @Override
        public void run() {
            while (true) {
                myNumber.waitToEven();  //等待数据变成奇数
                System.out.println("even:" + myNumber.getVal());
                myNumber.increase();
                if (myNumber.getVal() > 99) {
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        MyNumber n = new MyNumber(0);
        Thread old = new Thread(new SingleNumber(n), "old-thread");
        Thread even = new Thread(new DoubleNumber(n), "even-thread");
        old.start();
        even.start();
    }

}

//class MyNumber2 {
//    private Lock lock = new ReentrantLock();
//    private Condition condition = lock.newCondition();
//    private int val;
//
//    public MyNumber2(int val) {
//        this.val = val;
//    }
//
//    public int getVal() {
//        return val;
//    }
//
//    public void increase() {
//        lock.lock();
//        try {
//            val++;
//            condition.signalAll(); //通知线程
//        } finally {
//            lock.unlock();
//        }
//
//    }
//
//    public void waitToOld() {
//        lock.lock();
//        try {
//            while ((val % 2) == 0) {
//                try {
//                    System.out.println("i am should print old ,but now is even:" + val + ",so wait");
//                    condition.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void waitToEven() {
//        lock.lock(); //显示的锁定
//        try {
//            while ((val % 2) != 0) {
//                try {
//                    System.out.println("i am should print even ,but now old:" + val + ",so wait");
//                    condition.await();//执行等待
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        } finally {
//            lock.unlock(); //显示的释放
//        }
//    }
//
//    public static void main(String[] args) {
//        MyNumber n = new MyNumber2(0);
//        Thread old = new Thread(new MyNumber2.SingleNumber(n), "old-thread");
//        Thread even = new Thread(new MyNumber2.DoubleNumber(n), "even-thread");
//        old.start();
//        even.start();
//    }
//
//}