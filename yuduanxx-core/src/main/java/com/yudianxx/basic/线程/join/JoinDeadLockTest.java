package com.yudianxx.basic.线程.join;

/**
 * @author huangyongwen
 * @date 2020/7/21
 * @Description
 */
public class JoinDeadLockTest {

}

 class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        JoinDemo demo=new JoinDemo(); //关键是这个demo锁
        Thread t2=new Thread(new Runnable() {

            public void run() {
                System.err.println("Thread-2尝试获取锁");
                synchronized(demo){
                    demo.doSomething();
                    demo.doSomethingAgain();
                }
            }
        },"Thread-2");

        Thread t1=new Thread(new Runnable() {

            public void run() {
                System.err.println("Thread-1尝试获取锁");
                synchronized(demo){
                    demo.doSomething();

                    try {
                        t2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    demo.doSomethingAgain();
                }
            }
        },"Thread-1");

        t1.start();
        //休眠一秒。干扰线程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t2.start();

        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
    }
}
class JoinDemo{
    public  void doSomething(){
        String name=Thread.currentThread().getName();
        System.err.println(name+"获得了锁");

        //休眠一秒。干扰线程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void doSomethingAgain(){
        String name=Thread.currentThread().getName();

        //休眠一秒。干扰线程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.err.println(name+"释放了锁 Again");
    }
}