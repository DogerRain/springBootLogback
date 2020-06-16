package com.yudianxx.common;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author huangyongwen
 * @date 2020/6/11
 * @Description
 */

public class IPUtils {
    public static void main(String[] args) {
        try {
            System.out.println(AddressUtil.getAddress(getIPByRemoteService()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public static String getIPByRemoteService(){
        String url = "http://ip-api.com/json";
        JSONObject reponse =  HttpRequestUtils.httpPost(url,null);
        return reponse.get("query").toString();
    }
}

