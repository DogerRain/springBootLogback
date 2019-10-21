package com.yudianxx.basic.并发;

public class Volatile {
    public static boolean stop = false;
//    public volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
                System.out.println(i);
            }
        });
        thread.start();
        System.out.println("线程开始");
        Thread.sleep(1000);
        stop = true; //睡眠了1秒后,主线程要修改为true，但是thread线程无法获stop的值，还在循环
    }
}


/**
 * @Author: Administrator
 * @Date: 2019/10/11  22:45
 * @Description: volatile更直观
 * @Param:
 * @return:
 */
class VariableTest {

    public static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        new Thread(threadA, "threadA").start();
        Thread.sleep(1000l);//为了保证threadA比threadB先启动，sleep一下
        new Thread(threadB, "threadB").start();


    }

    static class ThreadA extends Thread {
        public void run() {
            while (true) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + " : flag is " + flag);
                    break;
                }
            }

        }

    }

    static class ThreadB extends Thread {
        public void run() {
            flag = true;
            System.out.println(Thread.currentThread().getName() + " : flag is " + flag);
        }
    }
}

//结果：
//        threadB : flag is true
//
//所以只有threadB执行了，但是ThreadB执行了，修改了flag的值，但是threadA拿不到flag的值，导致threadA没有进入if