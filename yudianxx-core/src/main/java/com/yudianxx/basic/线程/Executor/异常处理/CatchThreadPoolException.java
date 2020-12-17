package com.yudianxx.basic.线程.Executor.异常处理;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author huangyongwen
 * @date 2020/7/17
 * @Description
 */
@Slf4j
public class CatchThreadPoolException {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                1L,
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(1024),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        //设置线程异常处理器
                        thread.setUncaughtExceptionHandler((Thread thread1, Throwable e) -> {
                            System.out.println("factory的exceptionHandler捕捉到异常--->>> \n" + e.getMessage());
                        });
                        return thread;
                    }
                }
        ) {
            /**
             * 捕获{@code FutureTask<?>}抛出的异常
             *
             * @param r
             * @param t
             */
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (r instanceof FutureTask<?>) {
                    try {
                        //get()的时候会将异常内的异常抛出
                        ((FutureTask<?>) r).get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    } catch (ExecutionException e) {
                        log.error("捕获到线程的异常返回值", e);
                    }
                }
                //Throwable t永远为null，拿不到异常信息
                //log.error("afterExecute中捕获到异常，", t);
            }
        };

/*        threadPoolExecutor.execute(new Runnable() {
                                       @Override
                                       public void run() {
                                           throw new RuntimeException("execute()发生异常");
                                       }
                                   }
        );
        TimeUnit.MILLISECONDS.sleep(200L);*/

   /*     threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("submit.run()发生异常");
            }
        });
        TimeUnit.MILLISECONDS.sleep(200L);*/

        threadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                throw new RuntimeException("submit.call()发生异常");
            }
        }).get();   //get()的时候会将异常抛出

        threadPoolExecutor.shutdown();
    }
}