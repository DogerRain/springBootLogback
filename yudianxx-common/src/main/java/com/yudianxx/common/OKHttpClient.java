//package com.yudianxx.common;
//
//import okhttp3.FormBody;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author huangyongwen
// * @date 2020/6/11
// * @Description
// */
//public class OKHttpClient {
//
//    private void get
//ze
//    public String get(String url, Map<String, String> params) {
//
//
//        Request request = new Request.Builder()
//                .url(url)
//                .get()//默认就是GET请求，可以不写
//                .build();
//
//
//        Request request = new Request.Builder().url(url).method("GET", null).build();
//    }
//
//    public String post(String url, Map<String, String> params) {
//
//
//        FormBody.Builder builder = new FormBody.Builder();
//        for (String key : params.keySet()) {
//            builder.add(key, params.get(key));
//        }
//        FormBody body = builder.build();
//        Request request = new Request.Builder().url(url).post(body).build();
//
//    }
//
//}
