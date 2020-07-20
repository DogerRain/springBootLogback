package com.yudianxx.basic.线程.Executor.异常处理;

/**
 * @author huangyongwen
 * @date 2020/7/20
 * @Description
 */
public class OtherException {
    static class MyThread implements Runnable {

        @Override
        public void run() {
            throw new RuntimeException("子线程运行出错");
        }
    }

    public static void main(String[] args) throws Exception {
        Runnable runnable = new MyThread();
        try {
            for (int i = 0; i < 3; i++) {
                Thread thread = new Thread(runnable);
                thread.start();
            }
        }catch (Exception e){
            throw new Exception("主线程捕获异常");
        }
    }
}
