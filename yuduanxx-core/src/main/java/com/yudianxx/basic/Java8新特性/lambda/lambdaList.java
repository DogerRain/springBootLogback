package com.yudianxx.basic.Java8新特性.lambda;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huangyongwen
 * @date 2020/11/24
 * @Description
 */
public class lambdaList {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1", "2", "3", "1");
        Map<String, List<String>> map = list.stream().collect(Collectors.toMap(key -> key,
                value -> Lists.newArrayList(value),
                (List<String> newValueList, List<String> oldValueList) -> {
                    oldValueList.addAll(newValueList);
                    return oldValueList;
                }));
        System.out.println(JSON.toJSONString(map));

        test();
    }

    public static void test() {
        B b1 = new B("小明", "男");
        B b2 = new B("小刚", "男");
        B b3 = new B("小红", "女");
        List<B> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);


        Map<String, List<B>> partsMap = list.stream().collect(Collectors.toMap(B::getSex, part ->
                Lists.newArrayList(part), (List<B> newValueList, List<B> oldValueList) ->
        {
            oldValueList.addAll(newValueList);
            return oldValueList;
        }));
        System.out.println(JSON.toJSONString(partsMap));
    }


}

@Data
class A {
    String sex;
    String m;
    List<B> list;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class B {
    String name;
    String sex;
}