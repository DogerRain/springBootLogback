package com.yudianxx.basicDataConstruction.集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 数组与List转换 {
    public static void main(String[] args) {
        // list to array
        List<String> list = new ArrayList<String>();
        list.add("HaC");
        list.add("HelloCoder");
        Object[] str = list.toArray();

        // array to list
        String[] array = new String[]{"HaC", "HelloCoder"};
        List<String> mylist = Arrays.asList(array);

    }
}
