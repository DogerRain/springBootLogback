package 集合;

import java.util.*;

/**
 * @author huangyongwen
 * @date 2021/1/26
 * @Description
 */

class Car {
    private String number;
    private String carName;

    Car(String number, String carName) {
        this.number = number;
        this.carName = carName;
    }
}

public class MapTest {
    public static void main(String[] args) {
//        Car wuLingHongGuang = new Car("粤M88888", "五菱宏光");
//        Car baoMa = new Car("粤M66666", "宝马");
//        Map<Integer, Car> map = new HashMap<>();
//        map.put(1, wuLingHongGuang);
//        map.put(2, baoMa);

        testHashTable();
        testTreeMap();
    }

    static void test1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "五菱宏光");
        map.put(2, "宝马");
        map.put(3, "奥迪");
        map.put(null, null);

        System.out.println(map.get(1)); //五菱宏光
        System.out.println(map.put(1, "帅气的五菱宏光")); //五菱宏光
        System.out.println(map.get(1)); //帅气的五菱宏光
        System.out.println(map.get(null)); //null
        System.out.println(map.size()); // 3
        System.out.println(map.isEmpty()); // false
        System.out.println(map.containsKey(1)); //true
        System.out.println(map.containsValue("奥迪")); //true



//
//        Map<String, String> map1 = new HashMap();
//        map1.put("key", "value");
//        String value1 = map1.get("key");
//
//        Map map2 = new HashMap();
//        map2.put("key", "value");
//        String value = map2.get("key");



    }

    static void testHashTable() {
        Map<Integer, String> map1 = new Hashtable<>();
        map1.put(1, "五菱宏光");
        map1.put(2, null);
        System.out.println(map1.put(1, "帅气的五菱宏光")); //把五菱宏光换一下
        System.out.println(map1.put(2, "五"));
        System.out.println(map1.containsKey(1));
        System.out.println(map1.containsValue(""));
    }

    static void testTreeMap() {
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "五菱宏光");
        treeMap.put(2, null);
    }


}

class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "五菱宏光");
        map.put(3, "奥迪");
        map.put(2, "宝马");
        //1、使用keySet遍历
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

        //2、使用 Map.entrySet 遍历
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        //如果是jdk1.8及以上，可以使用lambda表达式
        map.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });


        //3、Iterator
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        //4、通过Map.values()遍历所有的value，但不能遍历key
        for (String value : map.values()) {
            System.out.println("value: " + value);
        }

//        Map<Integer, String> treeMap = new TreeMap<>();
//        treeMap.put(1, "五菱宏光");
//        treeMap.put(3, "奥迪");
//        treeMap.put(2, "宝马");
//        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
//            Integer key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println(key + " = " + value);
//        }


    }
}