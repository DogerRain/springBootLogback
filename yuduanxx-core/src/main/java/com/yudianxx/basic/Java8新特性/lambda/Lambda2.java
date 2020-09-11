package com.yudianxx.basic.Java8新特性.lambda;

import java.util.*;

/**
 * @author huangyongwen
 * @date 2020/9/2
 * @Description
 */
public class Lambda2 {


    public static void main(String[] args) {
        //Java Hash-Map foreach supports BiConsumer
        HashMap<String, Integer> dummyValues = new HashMap<>();
        dummyValues.put("One", 1);
        dummyValues.put("Two", 2);
        dummyValues.put("Three", 3);

        dummyValues.forEach((key,value) -> System.out.println(key+"-"+value));

    }

}
