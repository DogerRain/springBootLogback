package com.yudianxx.springBootDemo;

import com.alibaba.fastjson.JSON;
import com.meizu.push.sdk.server.IFlymePush;
import com.meizu.push.sdk.server.PushResult;
import com.meizu.push.sdk.server.ResultPack;
import com.meizu.push.sdk.server.VarnishedMessage;
import com.meizu.push.sdk.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.TreeMap;

/**
 * @author huangyongwen
 * @date 2020/4/27
 * @Description
 */
@Slf4j
public class TestPushMessage {


    @Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        //secret要提供
        String secret = "test";
        System.out.println(getSignature(map,secret));
    }

    /**
     * @param paramMap 请求参数
     * @param secret   密钥
     * @return md5摘要, 返回签名值
     */
    public static String getSignature(Map<String, String> paramMap, String secret) {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, String> sortedParams = new TreeMap<String, String>(paramMap);
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();

        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder basestring = new StringBuilder();
        for (Map.Entry<String, String> param : entrys) {
            basestring.append(param.getKey()).append("=").append(param.getValue());
        }
        basestring.append(secret);

        log.debug("basestring is:{}", new Object[]{basestring.toString()});

        // 使用MD5对待签名串求签
        return MD5Util.MD5Encode(basestring.toString());
    }

    public void testVarnishedMessagePush() throws Exception {
        //推送对象
        String APP_SECRET_KEY ="test";
        IFlymePush push = new IFlymePush(APP_SECRET_KEY, true);
        //组装消息
        VarnishedMessage message = new VarnishedMessage.Builder().appId(1000L)
                .title("推送标题").content("推送内容")
                .noticeExpandType(1)
                .noticeExpandContent("展开文本内容")
                .clickType(2).url("http://www.baidu.com").parameters(JSON.parseObject("{\"k1\":\"value1\",\"k2\":0,\"k3\":\"value3\"}"))
                .offLine(true).validTime(12)
                .suspend(true).clearNoticeBar(true).vibrate(true).lights(true).sound(true)
                .build();

        //目标用户
        List<String> pushIds = new ArrayList<String>();
        pushIds.add("pusId1");
        pushIds.add("pushId2");
        try {
            ResultPack<PushResult> result = push.pushMessage(message, pushIds, 10);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
