package com.yudianxx.basic.线程.ThreadDemo;

import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * @author huangyongwen
 * @date 2020/6/2
 * @Description
 */
public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //异步
                OKHTTPAsynchronous();
                //同步
                OKHTTPSynchronize();
//                try {
//                    Thread.sleep(2*1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                //子线程也是有顺序的执行
                for (int i = 1; i <= 100; i++) {
                    System.out.println(i);
                }
                System.out.println("----1-----");
                System.out.println("----2-----");
            }
        });
        thread.start();
        System.out.println("主线程2");
    }

    //异步，不阻塞线程
    private static void OKHTTPAsynchronous() {
        String url = "https://meizitu.baimuxym.cn/meizitu/test";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                System.out.println("falure" + e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }

    //同步
    private static void OKHTTPSynchronize() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://meizitu.baimuxym.cn/meizitu/test")
                .get().build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
