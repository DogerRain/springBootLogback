package com.yudianxx.basic.线程.Executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author huangyongwen
 * @date 2020/5/7
 * @Description 四种线程池拒绝策略
 */
public class SubmitAndExecute {
    public static void main(String[] args) {
        int corePoolSize = 2; //线程池维护线程的最少数量
        int maxPoolSize = 3; //线程池维护线程的最大数量
        long keepAliveTime = 5; //线程池维护线程所允许的空闲时间（解释：当线程池的数量超过corePoolSize时，多余的空闲线程的存活时间。）
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();

        ThreadFactory factory = (Runnable r) -> {
            Thread t = new Thread(r);
            t.setDefaultUncaughtExceptionHandler((Thread thread1, Throwable e) -> {
                System.out.println("线程工厂设置的exceptionHandler:" + e.getMessage());
            });
            return t;
        };

//        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, queue, factory, rejectedExecutionHandler);

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        //使用factory 捕获异常
        ExecutorService executorService2 = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10), factory);

        executorService.execute(() -> {
            int i = 1 / 0;  //会抛出报错
        });

        executorService.execute(() -> {
            System.out.println("当线程池抛出异常后继续新的任务1:{execute}");
        });


        executorService.submit(() -> {
            int i = 1 / 0; //如果这里没有捕获异常，是不会抛出异常的
        });

        executorService2.submit(() -> {
            int i = 1 / 0; //用了factory的UncaughtExceptionHandler也没有用
        });

        /**
         * 以上执行submit无法捕捉线程池中的异常，假如要捕获submit的异常，可以使用以下的方法:
         */
        Callable callable=()->{return 1/0;};
        //提交Callable进线程池，返回future
        Future future = executorService.submit(callable);
        try {
            //获取线程池里面的结果
            Integer a= (Integer) future.get();
            System.out.println("future中获取结果"+a);
        } catch (Exception e) {
            //获取线程池里面的异常
            System.out.println("future中获取异常"+e.getMessage());
        }

        executorService.submit(() -> {
            System.out.println("当线程池抛出异常后继续新的任务2:{submit}");
        });
    }




}


