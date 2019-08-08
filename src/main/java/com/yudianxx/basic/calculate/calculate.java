package com.yudianxx.basic.calculate;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//k++ 最后才执行++；++k是先运算得到k再执行，
public class calculate {
    public static void main(String[] args) {
        int i=0;
        int j=1;
        int k=2;
        System.out.println(i++);
        System.out.println(++i);
        System.out.println(i+1);
        method(k+2);
        method(k++);
        method(++k);
        method2();
    }
    static void method(int in){
        System.out.println(in);

//        String

    }
    static void method2(){
        List<String> list = Lists.newArrayList("1", "2", "3", "1");
        Map<String, List<String>> map = list.stream().collect(Collectors.toMap(key -> key,
                value -> Lists.newArrayList(value),
                (List<String> newValueList, List<String> oldValueList) -> {
                    oldValueList.addAll(newValueList);
                    return oldValueList;
                }));
        System.out.println(map);
    }
}
