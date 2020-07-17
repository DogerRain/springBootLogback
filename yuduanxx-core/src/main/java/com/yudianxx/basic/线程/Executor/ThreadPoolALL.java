package com.yudianxx.basic.线程.Executor;

import java.util.concurrent.*;

/**
 * @author huangyongwen
 * @date 2020/7/15
 * @Description
 */
public class ThreadPoolALL {
    public static void main(String[] args) {
        new ThreadPoolALL().ExecutorThreadPool();
    }

    static class TestRunnable implements Runnable {
        static int i = 0;

        @Override
        public void run() {
          synchronized (this){
              int count = getCount();
              System.out.println(Thread.currentThread().getName() + "  线程被调用了。第" + count + "次");
              if (count == 10) {
                  throw new RuntimeException("Runnable 任务出错了");
              }
          }

        }

        public static int getCount() {
            return ++i;
        }
    }

    static class TestCallable implements Callable<String> {
        static int i = 0;

        public static int getCount() {
            return ++i;
        }

        //可定义回参类型
        @Override
        public String call() {
            int count = getCount();
            System.out.println(Thread.currentThread().getName() + "  线程被调用了。第" + count + "次");
            if (count == 10) {
                throw new RuntimeException("Callable 任务出错了");
            }
            return "finish";
        }
    }




    /**
     * ThreadPoolExecutor是ExecutorSerivce接口的具体实现
     * 即ExecutorSerivce最后也是调用ThreadPoolExecutor的
     * ThreadPoolExecutor提供了很多参数
     * 阿里开发手册建议使用这种方法创建线程池
     */
    public void ExecutorThreadPool() {
        //自定义线程池
        int corePoolSize = 2; //线程池维护线程的最少数量
        int maxPoolSize = 3; //线程池维护线程的最大数量
        long keepAliveTime = 60; //线程池维护线程所允许的空闲时间（解释：当线程池的数量超过corePoolSize时，多余的空闲线程的存活时间。）
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(10);
        //或者
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                SecurityManager s = System.getSecurityManager();
                ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
                Thread t = new Thread(group, r);
                //设置优先级
                if (t.getPriority() != Thread.NORM_PRIORITY) {
                    t.setPriority(Thread.NORM_PRIORITY);
                }
                //设置错误处理
                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        //自定义处理错误
                        System.out.println("factory捕获了错误--->>>" + t.getName() + e);
                    }
                });
                return t;
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, queue, factory, rejectedExecutionHandler);



        TestRunnable testRunnable = new TestRunnable();
        for (int i = 0; i < 10; i++) {
            executor.execute(testRunnable);
        }


        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        TestCallable testCallable = new TestCallable();
        for (int i = 0; i < 10; i++) {
            Future<String> future = executor.submit(testCallable);
            try {
                future.get();
                String s = future.get();
                if ("finish".equals(s)) {
                    System.out.println("future.isDone()的值：" + future.isDone() + "，经过返回值比较，submit方法执行任务成功，当前线程名称--->>>" + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
