package com.yudianxx.basic.线程;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author huangyongwen
 * @date 2020/6/29
 * @Description
 */
public class 例子1 {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        Object object = new Object();

//        synchronized (object) {
//            threadA.start();
//        }
//        System.out.println(11111111);

        Future future = Executors.newFixedThreadPool(2).submit(new ThreadA());
        try {
            if (future.get() == null) {//如果Future's get返回null，任务完成
                System.out.println("任务完成");
            }
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
            //否则我们可以看看任务失败的原因是什么
            System.out.println(e.getCause().getMessage());
        }

    }

}

class ThreadA extends Thread {
    @Override
    public void run() {
        super.run();
        int i = 1000;
        while (i-- > 0) {
            System.out.println(2222222);
        }
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
