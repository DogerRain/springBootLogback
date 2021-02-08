package com.yudianxx.basic.线程.ReentrantLock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangyongwen
 * @date 2021/2/5
 * @Description
 */
public class ReentrantLockTryLockDemo {
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new DeadLockDemo(lock1, lock2), "Thread1");
        Thread thread2 = new Thread(new DeadLockDemo(lock2, lock1), "Thread2");
        thread1.start();
        thread2.start();

    }

    static class DeadLockDemo implements Runnable {
        Lock lockA;
        Lock lockB;

        public DeadLockDemo(Lock lockA, Lock lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }

        @Override
        public void run() {
            letsTryLock();
//            letsTryLock2();
//            letsTryLock3();
//            letsTryLock4();
        }


        private void letsTryLock() {
            try {
                while (true) {
                    if (!lockA.tryLock(0, TimeUnit.SECONDS)) {
                        System.out.println(Thread.currentThread().getName() + " 正在等待 " + lockA);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " 拿到了 " + lockA);
                    }
//                    TimeUnit.SECONDS.sleep(2);
                    if (!lockB.tryLock(0, TimeUnit.SECONDS)) {
                        System.out.println(Thread.currentThread().getName() + " 正在等待 " + lockB);
                        lockA.unlock();
                    } else {
                        System.out.println(Thread.currentThread().getName() + " 同时拿到锁loackA、lockB ");
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockA.unlock();
                lockB.unlock();
                System.out.println(Thread.currentThread().getName() + "正常结束!");
            }
        }

        /**
         * 傻逼玩意
         */
        private void letsTryLock2() {
            boolean flag = true;
            while (true) {
                if (lockA.tryLock()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获得：" + lockB);
                        //休眠
                        TimeUnit.SECONDS.sleep(2);
                        if (lockB.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 也成功获得：" + lockB);
                                break;
                            } finally {
                                lockB.unlock();
                            }
                        } else {
                            lockA.unlock();
                            flag = false;
                            System.out.println(Thread.currentThread().getName() + "\t 正在等待：" + lockB);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (flag) {
                            lockA.unlock();
                        }
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t 正在等待：" + lockA);
                }
            }
            System.out.println(Thread.currentThread().getName() + "正常结束!");
        }

        private void letsTryLock3() {
            try {
                while (!lockA.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + "\t 正在等待锁Round1：" + lockA);
                }
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获得：" + lockB);

                //休眠
                TimeUnit.SECONDS.sleep(2);

                while (!lockB.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + "\t 正在等待锁Round2：" + lockB);
                    //如果不释放锁，会陷入死锁
                    lockA.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 同时持有：" + lockB);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockB.unlock();
                System.out.println(Thread.currentThread().getName() + "正常结束!");
            }
        }

        /**
         * 傻逼博主的
         */
        private void letsTryLock4() {
            try {
                while (!lock1.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + "\t 正在等待：" + lock1);
                }
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lock1 + "\t 尝试获得：" + lock2);

                //休眠
                TimeUnit.SECONDS.sleep(2);

                while (!lock2.tryLock(1, TimeUnit.SECONDS)) {
                    //如果不释放锁，会陷入死锁,我试了一下不行
                    System.out.println(Thread.currentThread().getName() + "\t 正在等待锁中" + lock2);
//                    lock1.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lock1 + "\t 同时持有：" + lock2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockA.unlock();
                lockB.unlock();
                System.out.println(Thread.currentThread().getName() + "正常结束!");
            }

        }

//                while (!lockA.tryLock(2, TimeUnit.SECONDS)) {
//                    System.out.println(Thread.currentThread().getName() + "\t 正在等待：" + lockA);
//                    TimeUnit.MILLISECONDS.sleep(1);
//                }
//                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获得：" + lockB);
//
//                //休眠
//                TimeUnit.SECONDS.sleep(5);
//
//                while (!lockB.tryLock(2, TimeUnit.SECONDS)) {
//                    //如果不释放锁，会陷入死锁
//                    System.out.println(Thread.currentThread().getName() + "\t 正在等待锁中" + lockB);
//                    TimeUnit.MILLISECONDS.sleep(1);
//                    lockA.unlock();
//                }
//                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 同时持有：" + lockB);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
////                lockA.unlock();
////                lockB.unlock();
//                System.out.println(Thread.currentThread().getName() + "正常结束!");
//            }

        public static void copyFileByChannel(File source, File dest) throws
                IOException {
            try (FileChannel sourceChannel = new FileInputStream(source)
                    .getChannel();
                 FileChannel targetChannel = new FileOutputStream(dest).getChannel();) {
                for (long count = sourceChannel.size(); count > 0; ) {
                    long transferred = sourceChannel.transferTo(
                            sourceChannel.position(), count, targetChannel);
                    sourceChannel.position(sourceChannel.position() + transferred);
                    count -= transferred;
                }
            }
        }


    }

}
