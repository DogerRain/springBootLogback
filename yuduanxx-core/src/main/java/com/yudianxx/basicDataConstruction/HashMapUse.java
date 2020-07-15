package com.yudianxx.basicDataConstruction;

import java.util.HashMap;
import java.util.Map;

public class HashMapUse {
    public static void main(String[] args) {

        HashMapUse hashMapTest = new HashMapUse();
//        hashMapTest.nullValue();
        hashMapTest.equals();

    }

    private void equals(){
        Map<String,String> map = new HashMap<>();
        map.put("key","key");
        System.out.println( map.equals(map));
        System.out.println(map.get("1")==null);

        String []a[] = new String[1][1];


    }

    private void hashcode() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "甲");
        System.out.println(map.get("1").hashCode());
        int hashcode = "甲".hashCode();
        System.out.println(hashcode);
    }

    private String test() {
        if (1 == 1) {

        }
        return "";
    }

    private void mergeMap() {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("one", "一");
        map1.put("two", "二");
        map1.put("three", "三");

        Map<String, String> map2 = new HashMap<String, String>();
        map1.put("ten", "十");
        map1.put("nine", "九");
        map1.put("eight", "八");

        // 合并
//        putAll可以合并两个MAP，只不过如果有相同的key那么用后面的覆盖前面的
        Map<String, String> combineResultMap = new HashMap<String, String>();
        combineResultMap.putAll(map1);
        combineResultMap.putAll(map2);

        // 合并后打印出所有内容
        for (Map.Entry<String, String> entry : combineResultMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private void nullValue() {
        //map可以放null值,key 也可以是null
        Map<String, String> map = new HashMap<>();
        map.put("1", null);
        map.put(null, "1");
        map.put("2", "value_2");
        System.out.println(map.get("1"));
        System.out.println(map.get(null));

        String returnValue = map.put("2", "2_value_lastest");
        String returnValue1 = map.put("3", "3_value_lastest");
        //如果key存在，则返回旧值key的value
        System.out.println(returnValue);
//        如果key不存在，则返回null
        System.out.println(returnValue1);
    }


}
