package com.yudianxx.basic.线程.volatile作用;

/**
 * @author huangyongwen
 * @date 2020/7/23
 * @Description
 */
public class VolatileTest3 extends Thread {

    private Boolean flag = false;

    public static void main(String[] args) throws InterruptedException {


        VolatileTest3 volatileTest3 = new VolatileTest3();
        VolatileTest3 volatileTest4 = new VolatileTest3();

//        volatileTest3.start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                int i =1;
                while (volatileTest3.flag ) {
                    try {
                        sleep(1 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程一直在执行" + i ++  +"次 "+"flag :" +volatileTest3.flag);
                }
            }
        }).start();


//        sleep(10*1000);


        new Thread(new Runnable() {
            @Override
            public void run() {
                volatileTest3.flag = true;
            }
        }).start();
//        volatileTest3.setFlag();


    }

    public void run() {
        int i =1;
        while (flag) {
            try {
                sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程一直在执行" + i ++  +"次");
        }
    }

    private void setFlag() {
        flag = false;
    }

}
