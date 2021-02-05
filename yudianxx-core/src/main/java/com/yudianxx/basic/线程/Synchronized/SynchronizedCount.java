package com.yudianxx.basic.线程.Synchronized;

/**
 * @author huangyongwen
 * @date 2021/2/4
 * @Description
 */
public class SynchronizedCount extends Thread {
    public static Counter counter = new Counter();
    public Integer flag =1;

    public static class Counter {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    @Override
    public void run() {
//        synchronized (flag){
            for (int i = 0; i < 100; i++) {
                counter.addCount();
            }
//        }
    }

    public static void main(String[] args) {
        SynchronizedCount[] synchronizedCounts = new SynchronizedCount[100];
        for (int i = 0; i < 100; i++) {
            synchronizedCounts[i] = new SynchronizedCount();
        }
        for (int i = 0; i < 100; i++) {
            synchronizedCounts[i].start();
        }
        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最后的count值：" + counter.getCount());
    }
}
