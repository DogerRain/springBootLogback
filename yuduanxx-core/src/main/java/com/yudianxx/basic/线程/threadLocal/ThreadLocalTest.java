package com.yudianxx.basic.线程.threadLocal;

/**
 * @author huangyongwen
 * @date 2020/7/27
 * @Description
 */
public class ThreadLocalTest {

    public static void main(String[] args) {


        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    threadLocal.set(1);
                    System.out.println(threadLocal.get());
                }finally {
                    threadLocal.remove();
                }
            }
        }, "Thread1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(2);
                System.out.println(threadLocal.get());
            }
        }, "Thread2").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(threadLocal.get());
            }
        }, "Thread3").start();
    }

}
