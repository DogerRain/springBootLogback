package com.yudianxx.basic.线程.join;

/**
 * @author huangyongwen
 * @date 2020/7/22
 * @Description
 */
public class HighConcurrency {

    public static void main(String[] args) throws InterruptedException {

        final Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("t2");
            }
        });
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3");
            }
        });
        t3.start();
        Thread.sleep(10);    //无法保证此时t2已经是运行时状态了，所以上面的 t2.join 不会生效
        t2.start();
    }
}