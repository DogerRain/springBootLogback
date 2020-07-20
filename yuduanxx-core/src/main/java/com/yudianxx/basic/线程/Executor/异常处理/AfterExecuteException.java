package com.yudianxx.basic.线程.Executor.异常处理;

import java.util.concurrent.*;

/**
 * @author huangyongwen
 * @date 2020/7/20
 * @Description
 */
public class AfterExecuteException {
    public static void main(String[] args) {
        int corePoolSize = 3;
        int maxPoolSize = 5;
        long keepAliveTime = 10;
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(5);
        ThreadFactory factory = (Runnable r) -> {
            Thread t = new Thread(r);
            t.setDefaultUncaughtExceptionHandler((Thread thread1, Throwable e) -> {
                System.out.println("factory的exceptionHandler捕捉到异常--->>> \n" + e.getMessage());
            });
            return t;
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
                TimeUnit.SECONDS, queue) {

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (r instanceof FutureTask<?>) {
                    try {
                        ((FutureTask<?>) r).get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    } catch (ExecutionException e) {
                        System.out.println("afterExecute 捕获到线程的异常返回值" + e.getMessage());
                    }
                }
            }
        };
        runnable(executor);
    }

    static void runnable(ThreadPoolExecutor executor) {
        TestRunnable testRunnable = new TestRunnable();
        for (int i = 0; i < 5; i++) {
            executor.submit(testRunnable);
        }
        executor.shutdown();
    }

    static class TestRunnable implements Runnable {
        private static volatile int i = 0;

        @Override
        public void run() {
            i++;
            if (i == 2) {
                throw new RuntimeException("子线程异常,当前 i 的 值：" + i);
            } else {
                System.out.println(Thread.currentThread().getName() + " 子线程执行--->>> i 的值：" + i);
            }
        }
    }
}
