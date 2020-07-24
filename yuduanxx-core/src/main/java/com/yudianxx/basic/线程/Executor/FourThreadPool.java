package com.yudianxx.basic.线程.Executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author huangyongwen
 * @date 2020/5/6
 * @Description
 */
public class FourThreadPool {
    public static void main(String[] args) {
/**
 * 阿里开发手册建议使用这种方法创建线程池
 */
//        ExecutorService defaultExecutor =new ThreadPoolExecutor();

//        new ScheduledThreadPoolExecutorTest().ScheduledThreadPoolExecutorTest();
//        ExecutorService executorService = new newCachedThreadPoolTest().newCachedThreadPoolTest();

//        ExecutorService executorService = new newFixedThreadPool().newFixedThreadPool();
        ExecutorService executorService = new newSingleThreadExecutor().newSingleThreadExecutor();

        //Runnable()
        for (int i = 0; i < 10; i++) {
            executorService.execute(new TestRunnable());
        }
        executorService.shutdown();

        //Callable()

        /*for (int i = 0; i < 5; i++) {
            Future<String> result = executorService.submit(new TestCallable());
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error occured while executing the submitted task");
                e.printStackTrace();
            }
            System.out.println("************* a" + i + " *************");
        }
        executorService.shutdown();
        */
    }

}

/**
 * Runnable是一种有很大局限性的抽象，虽然run()能写入到日志文件或者将其结果放入某个共享的数据结构，但它不能返回一个值或者抛出一个受检查的异常。
 */
class TestRunnable implements Runnable {
    static int i = 1;



    @Override
    public void run() {
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(Thread.currentThread().getName() + "  线程被调用了。第" + getCount() + "次");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static int getCount() {
        return i++;
    }
}

/**
 * 它认为主入口点（即call()）将返回一个值，并可能抛出一个异常。Callable 和 Runnable 最大的区别就是可以 知道线程执行结束。
 */
class TestCallable implements Callable<String> {
    static int i = 1;

    public static int getCount() {
        return i++;
    }

    //可定义回参类型
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + "  线程被调用了。第" + getCount() + "次";
    }
}


class newSingleThreadExecutor {

    ExecutorService newSingleThreadExecutor() {
        /**
         * 1
         * 此线程池 Executor 只有一个线程。它用于以顺序方式的形式执行任务。
         * 如果此线程在执行任务时因异常而挂掉，则会创建一个新线程来替换此线程，后续任务将在新线程中执行。
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return executorService;
    }

}

class newFixedThreadPool {
    ExecutorService newFixedThreadPool() {
        /**
         * 2
         * 它是一个拥有固定数量线程的线程池。提交给 Executor 的任务由固定的 n 个线程执行，
         * 如果有更多的任务，它们存储在 LinkedBlockingQueue 里。这个数字 n 通常跟底层处理器CPU支持的线程总数有关。
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        return executorService;
    }
}


class ScheduledThreadPoolExecutorTest {

    ScheduledExecutorService ScheduledThreadPoolExecutorTest() {
        /**
         * 3
         * 当我们有一个需要定期运行的任务或者我们希望延迟某个任务时，就会使用此类型的 executor。
         */
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        executorService.scheduleAtFixedRate(new TestRunnable(), 2, 1, TimeUnit.SECONDS);
//        executorService.schedule(new TestRunnable(), 3, TimeUnit.SECONDS);

        return executorService;
    }


}


class newCachedThreadPoolTest {
    ExecutorService newCachedThreadPoolTest() {
        /**
         * 4
         * 此线程池的线程数不受限制。如果所有的线程都在忙于执行任务并且又有新的任务到来了，这个线程池将创建一个新的线程并将其提交到 Executor。
         * 只要其中一个线程变为空闲，它就会执行新的任务。 如果一个线程有 60 秒的时间都是空闲的，它们将被结束生命周期并从缓存中删除。
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        return executorService;
    }
}