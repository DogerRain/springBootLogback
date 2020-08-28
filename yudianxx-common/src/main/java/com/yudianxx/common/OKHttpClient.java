package com.yudianxx.common;

import okhttp3.*;

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


}
