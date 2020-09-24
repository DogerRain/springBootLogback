package com.yudianxx.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class HttpContextUtil {
    private HttpServletRequest request; //此处线程不安全

    String BASE_URL = "http://lastmile.meizu.com";

    @ModelAttribute
    public void bindRequest(HttpServletRequest request) {
        this.request = request; //此处request线程安全
    }

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }


    public void testGet() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        String api = "/lastmile/tasks";
        String url = String.format("%s%s", BASE_URL, api);
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void testPost() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String api = "/lastmile/tasks";
        String url = String.format("%s%s", BASE_URL, api);
        HttpPost httpPost = new HttpPost(url);
        UserVO userVO = UserVO.builder().name("h2t2").build();
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");  //post一定要设置请求头
        httpPost.setEntity(new StringEntity(JSONObject.toJSONString(userVO), "UTF-8"));
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在HttpClient4.3之后，原来的上传文件方法MultipartEntity已经不建议使用，现替换成新的httpmime下面的MultipartEntityBuilder。
     * 需要添加httpclient-4.5.jar、httpmime-4.5.jar两个包
     *
     */

    public void testUploadFile(){
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String api ="/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        HttpPost httpPost = new HttpPost(url);
        File file = new File("C:/Users/hetiantian/Desktop/学习/docker_practice.pdf");
        FileBody fileBody = new FileBody(file);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart("file", fileBody);  //addPart上传文件
        HttpEntity entity = builder.build();
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        new HttpContextUtil().testGet();
//        new HttpContextUtil().testPost();
    }
}

@Builder
@Data
class UserVO {
    String name;
}