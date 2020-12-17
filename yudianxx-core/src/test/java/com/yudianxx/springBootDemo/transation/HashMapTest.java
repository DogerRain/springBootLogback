package com.yudianxx.springBootDemo.transation;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangyongwen
 * @date 2020/5/26
 * @Description
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>();

        map.put("1",null);

        System.out.println(map.get("1"));

        String a =null;
        System.out.println(a);

        System.out.println(StringUtils.isBlank(a));
        System.out.println(StringUtils.isBlank(String.valueOf(map.get("1"))));
        System.out.println(StringUtils.isBlank(map.get("1")+""));

    }
}
