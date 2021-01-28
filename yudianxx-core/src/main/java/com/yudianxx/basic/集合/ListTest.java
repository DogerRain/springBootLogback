package com.yudianxx.basic.集合;

/**
 * @author huangyongwen
 * @date 2021/1/27
 * @Description
 */

import java.util.*;

/**
 * 数组转列表，列表转数组
 */
public class ListTest {
    public static void main(String[] args) {
        ListToArray();
//        ArrayToList1();
//        ArrayToList2();
//        ArrayToList3();
        ArrayToList4();
    }

    static void ListToArray() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("五菱宏光0");
        arrayList.add("五菱宏光1");
        arrayList.add("五菱宏光2");
        String[] strs = arrayList.toArray(new String[0]);
        System.out.println(strs[1]);
    }

    /**
     * 这种 **只能查改，不能对List增删** 否则会报 `UnsupportedOperationException`
     */
    static void ArrayToList1() {
        String[] strArray = new String[]{"1", "2"};
        List<String> list = Arrays.asList(strArray);
        //对转换后的list插入一条数据
//        list.add("1");
        System.out.println(list);
    }

    /**
     * 优化后，转为ArrayList
     */
    static void ArrayToList2() {
        String[] strArray = new String[]{"1", "2"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strArray));
        list.add("1");
    }

    /**
     * 暴力法
     */
    static void ArrayToList3() {
        String[] strArray = new String[]{"1", "2"};
        List<String> list = new ArrayList<>(strArray.length);
        for (String s : strArray) {
            list.add(s);
        }
    }

    /**
     * 使用Collections.addAll()，这种方法最高效
     */
    static void ArrayToList4() {
        String[] strArray = new String[]{"1", "2"};
        List<String> list = new ArrayList<>(strArray.length);
        Collections.addAll(list, strArray);
    }


    // 循环List的几种方法：

    static void listCount() {
        // 初始化一个 ArrayList
        List<String> list = new ArrayList<String>() {{ //匿名内部类
            add("Tom");
            add("Sally");
            add("John");
        }};

        //方法一  暴力循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


        // 方法二 迭代器
        Iterator it1 = list.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }


        // 方法三：foreach
        for (String str : list) {
            System.out.println(str);
        }


    }
}

