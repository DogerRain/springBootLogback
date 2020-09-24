package com.yudianxx.common;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author huangyongwen
 * @date 2020/6/11
 * @Description
 */
public class OKHttpClient {

    private OkHttpClient client = new OkHttpClient();
    private String BASE_URL = "";


    public String getRemoteLastestTask() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)//设置连接超时时间
                .readTimeout(15, TimeUnit.SECONDS)//设置读取超时时间
                .build();
        Request request = new Request.Builder().url("http:")
                .get().build();
        Call call = client.newCall(request);
        String lastestJsonString = "";
        try {
            Response response = call.execute();
            lastestJsonString = response.body().string();
        } catch (IOException e) {
            if (e instanceof SocketTimeoutException) {//判断超时异常
//                Log.e(TAG, "连接超时", e);
            }
            if (e instanceof ConnectException) {//判断连接异常，报Failed to connect to XXX.XXX.XXX.XXX
//                Log.e(TAG, "连接异常", e);
            }
        } catch (Exception e) {
//            Log.e(TAG, "未知错误", e);
        }
        return lastestJsonString;
    }

    public void testGet() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    public void testPost() throws IOException {
        String api = "/api/user";
        String url = String.format("%s%s", BASE_URL, api);
        //请求参数
        JSONObject json = new JSONObject();
        json.put("name", "hetiantian");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), String.valueOf(json));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody) //post请求
                .build();
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    public void testUpload() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "docker_practice.pdf",
                        RequestBody.create(MediaType.parse("multipart/form-data"),
                                new File("C:/Users/hetiantian/Desktop/学习/docker_practice.pdf")))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)  //默认为GET请求，可以不写
                .build();
//            设置超时时间
//        client.newBuilder().connectTimeout(1,TimeUnit.SECONDS);
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }


}
