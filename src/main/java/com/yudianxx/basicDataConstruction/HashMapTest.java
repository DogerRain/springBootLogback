package com.yudianxx.basicDataConstruction;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        int n = 100;
//        n = n >>> 2;  //无符号右移两位2^2
//        n = n >>> 3;  //无符号右移两位2^3
        n = n >> 3;  //带符号右移两位2^3

        System.out.println(n);
        Map<String, String> map = new HashMap<>();
        map.put("1", "甲");
    }

    private String test() {
        if (1 == 1) {

        }
        return "";
    }


}
