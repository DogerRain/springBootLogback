package com.yudianxx.basic.线程.ThreadDemo;

import java.util.concurrent.*;

/**
 * @author huangyongwen
 * @date 2020/7/21
 * @Description
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> future = service.submit(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println("通过实现Callable接口");
                return "TRUE";
            }
        });
        try {
            String result = future.get();
            if (result.equals("TRUE")){
                System.out.println("线程执行完成");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
