package com.yudianxx.basic.线程.volatile作用;

/**
 * @author huangyongwen
 * @date 2020/7/23
 * @Description
 */
public class VolatileTest2 extends Thread {
    int count = 0;

    public void addCount() {
        count++;
    }


    public static void main(String[] args) throws InterruptedException {
        VolatileTest2 volatileTest2 = new VolatileTest2();
        VolatileTest2 volatileTest22 = new VolatileTest2();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i< 10000 ;i++){
                    volatileTest2.addCount();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
               for (int i =0;i< 10000 ;i++){
                   volatileTest2.addCount();
               }
            }
        });

        thread.start();
        thread2.start();

//        thread.join();
//        thread2.join();


        sleep(10*1000);


        System.out.println(volatileTest2.count);

    }

}
