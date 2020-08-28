package com.yudianxx.basic.http;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author huangyongwen
 * @date 2020/5/27
 * @Description
 */

public class HttpTest {

    public static void main(String[] args) {
        HttpTest httpTest = new HttpTest();
        httpTest.HttpURLConnectionTest();
    }


    /**
     * jdk自带的 HttpURLConnection 发起http请求
     */
    void HttpURLConnectionTest() {
        URL url;
        {
            try {
                //jdk自带的 jar
                url = new URL("http://127.0.0.1:8090/meizitu/test1");
                URLConnection rulConnection = url.openConnection();
                HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;

                //参数设置

                // 设定请求的方法为"POST"，默认是GET
                httpUrlConnection.setRequestMethod("POST");

                // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
                // http正文内，因此需要设为trueHTTPClient, 默认情况下是false;
                httpUrlConnection.setDoOutput(true);

                // Post 请求不能使用缓存
                httpUrlConnection.setUseCaches(false);

//                setConnectTimeout：设置连接主机超时（单位：毫秒）
//                setReadTimeout：设置从主机读取数据超时（单位：毫秒）
                httpUrlConnection.setConnectTimeout(3 * 1000);
                httpUrlConnection.setReadTimeout(4 * 1000);

                //设置传参方式，这也是默认的
                httpUrlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded;charset=" + Charset.forName("utf-8"));
                String content = "id=" + URLEncoder.encode("1", "utf-8"); //多个参数可以使用&连接，参考下面的拼装方法



//                httpUrlConnection.setRequestProperty("content-type","application/json;charset=" + Charset.forName("utf-8"));
//                构建json格式的传参
//                String data = "{\"id\":1}";

//                可以使用fastjson map转jsonString
//                String json =  JSONObject.toJSONString(map);


                // 连接，从上述第2条中url.openConnection()至此的配置必须要在connect之前完成，
                httpUrlConnection.connect();


                //设置参数
                DataOutputStream out = new DataOutputStream(httpUrlConnection
                        .getOutputStream());

                //传参
//                out.writeBytes(data);
                out.writeBytes(content);
                //流用完记得关
                out.flush();
                out.close();

                // 此处getOutputStream会隐含的进行connect(即：如同调用上面的connect()方法，
                // 所以在开发中不调用上述的connect()也可以)。
//                OutputStream outStrm = httpUrlConnection.getOutputStream();

//                返回

                if (httpUrlConnection.getResponseCode() == 200) {

                    StringBuilder sb = new StringBuilder();
                    InputStream in = httpUrlConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                    String readline = "";

                    while ((readline = bufferedReader.readLine()) != null) {
                        sb.append(readline);
                    }


                    System.out.println(sb.toString());


                    in.close();
                    bufferedReader.close();
                    httpUrlConnection.disconnect();


                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }

        }
    }


}

/**
 * 工具类 参数拼接
 */
class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String builderUrlParams(Map<String, String> params) {
        Set<String> keySet = params.keySet();
        List<String> keyList = new ArrayList<String>(keySet);
        Collections.sort(keyList);
        StringBuilder sb = new StringBuilder();
        for (String key : keyList) {
            String value = params.get(key);
            if (StringUtils.isEmpty(value)) {
                continue;
            }
            sb.append(key);
            sb.append("=");
            try {
                sb.append(URLEncoder.encode(params.get(key), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}