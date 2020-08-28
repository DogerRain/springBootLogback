package com.yudianxx.basic.线程.奇怪的线程;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangyongwen
 * @date 2020/8/12
 * @Description
 */
public class ThreadPoolTest {
    private int j = 0;

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    threadPoolTest.add();
                }
            });
        }

        List<Runnable> list= executorService.shutdownNow();
        list.forEach(item->{
            System.out.println(item);
        });
        System.out.println(threadPoolTest.j);
    }

    public int add() {
        j = j + 1;
        System.out.println(Thread.currentThread().getName() +" j=" + j);
        return j;
    }
}
