package com.yudianxx.basic.集合;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author huangyongwen
 * @date 2021/1/27
 * @Description
 */
public class MapTest {
    public static void main(String[] args) {
        Testmap();
    }

    //    遍历一个Map的几种方法
    static void Testmap() {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "五菱宏光");
        map.put(3, "奥迪");
//        Map返回
        //Map不存在返回null
        System.out.println(map.put(2, "宝马"));
        //Map存在返回旧值
        System.out.println(map.put(1, "111"));

        // 遍历方法1
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

        // 遍历方法2   常用
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        //如果是jdk1.8及以上，可以使用lambda表达式
        map.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });


        //3、遍历方法3   Iterator 迭代器 ，常用
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        //通过键来遍历
        Iterator iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        //通过值来遍历
        Iterator iterator2 = map.values().iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }


        //4、遍历方法3  通过Map.values()遍历所有的value，但不能遍历key
        for (String value : map.values()) {
            System.out.println("value: " + value);
        }
    }
}
