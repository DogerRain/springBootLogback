package com.yudianxx.basic.线程.workQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
    static int a = 1;
    float []f[]  = new float[1][];
    public static void main(String[] args) {

    }

    DelayQueueTest(){

    }

    void a(){

    }


    //实现Delayed接口
    class MessageObject implements Delayed {

        private int id;
        private String body;  //消息内容
        private long excuteTime;//执行时间

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }

    /*class Consumer implements Runnable {

        // 延时队列
        private DelayQueue<MessageObject> queue;

        public Consumer(DelayQueue<MessageObject> queue) {
            this.queue = queue;
        }

        *//*@Override
        public void run() {
            while (true) {
                try {
                    MessageObject take = queue.take();
                    System.out.println("消费消息：" + take.getId() + ":" + take.getBody());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*//*
    }*/

}

