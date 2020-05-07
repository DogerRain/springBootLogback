package com.yudianxx.basic.线程.Executor;

import java.util.concurrent.*;

/**
 * @author huangyongwen
 * @date 2020/5/7
 * @Description 四种线程池拒绝策略
 */
public class RejectedExecutionExceptionTest {
    public static void main(String[] args) {
        int corePoolSize = 2; //线程池维护线程的最少数量
        int maxPoolSize = 3; //线程池维护线程的最大数量
        long keepAliveTime = 5; //线程池维护线程所允许的空闲时间（解释：当线程池的数量超过corePoolSize时，多余的空闲线程的存活时间。）
        //缓存队列可以放多少个线程
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(2);
        //参数为空则默认无界
//        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();


//        System.out.println(Runtime.getRuntime().availableProcessors());//        系统的内核数

        /**
         * 这是线程池默认的拒绝策略，在任务不能再提交的时候，
         * 抛出异常，及时反馈程序运行状态。如果是比较关键的业务，推荐使用此拒绝策略，
         * 这样子在系统不能承载更大的并发量的时候，能够及时的通过异常发现。
         * 如果没有try.catch处理异常信息的话，会中断调用者的处理流程，后续任务得不到执行（跑不完20个）
         */
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();

        /**
         * 如果任务被拒绝了，则由调用线程（提交任务的线程）直接执行此任务
         * 通过结果可以看到，主线程main也执行了任务，这正说明了此拒绝策略由调用线程（提交任务的线程）直接执行被丢弃的任务的。
         */
//        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();

        /**
         * 丢弃任务，但是不抛出异常。如果线程队列已满，则后续提交的任务都会被丢弃，且是静默丢弃。
         * 实际运行中，打印出的信息不会有20条。
         */
//        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.DiscardPolicy();


        /**
         * 丢弃队列最前面的任务，然后重新提交被拒绝的任务。
         * 此拒绝策略，是一种喜新厌旧的拒绝策略。是否要采用此种拒绝策略，还得根据实际业务是否允许丢弃老任务来认真衡量
         * 实际运行中，打印出的信息不会有20条。
         */
//        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.DiscardOldestPolicy();

//        实现一个自己的线程池工厂，可以处理异常
        ThreadFactory factory = (Runnable r) -> {
            //创建一个线程
            Thread t = new Thread(r);
            //给创建的线程设置UncaughtExceptionHandler对象 里面实现异常的默认逻辑
            t.setDefaultUncaughtExceptionHandler((Thread thread1, Throwable e) -> {
                System.out.println("线程工厂设置的exceptionHandler: \n" + e.getMessage());
            });
            return t;
        };


//        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, queue, rejectedExecutionHandler);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, queue, factory, rejectedExecutionHandler);

        callable2(executor);
//        callable(executor);
        System.out.println("------------------------------");
//        runnable(executor);


    }

    static void runnable(ThreadPoolExecutor executor) {
        for (int i = 0; i < 20; i++) {
            executor.execute(new TestRunnable());
        }
//        executor.shutdown();
    }

    static void callable(ThreadPoolExecutor executor)  {
        for (int i = 0; i < 20; i++) {
            Future<String> result = executor.submit(new TestCallable()); //异步提交, non blocking
//            Future result  =executor.submit(new TestRunnable());//返回null表示执行成功，Runnable没有返回
            //这里一定要try catch
            try {
//                Thread.sleep(5*1000);
                System.out.println(Thread.currentThread().getName()+" | "+result.isDone() + " | " + result.get());  //如果没有sleep，为什么这里的result.isDone()返回的是false，可能是主线程执行比线程池快吧？
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
//        executor.shutdown();
    }


    static void callable2(ThreadPoolExecutor executor) {
        for (int i = 0; i < 20; i++) {
            Future<String> future = executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
//                    Thread.sleep(5000);
                    System.out.println("submit方法执行任务完成" + "   thread name: " + Thread.currentThread().getName());
                    return "SUCCESS";
                }
            });

            try {
                String s = future.get();
                if ("SUCCESS".equals(s)) {
                    System.out.println("future.isDone()的值：" + future.isDone() + "，经过返回值比较，submit方法执行任务成功    thread name: " + Thread.currentThread().getName());
//                    而这里的result.isDone()返回的是true？
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}


