package com.yudianxx.basic.Java8新特性.lambda;

import java.util.*;

/**
 * @author huangyongwen
 * @date 2020/9/2
 * @Description
 */
public class Lambda1 {


    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        int k[] = new int[]{12, 3, 4};

        //默认降序
        Collections.sort(names);
        //升序
        Collections.sort(names, Collections.reverseOrder());

        Collections.sort(Arrays.asList(k), Collections.reverseOrder());

        List<int[]> kk = Arrays.asList(k);

        System.out.println("K:" + kk.get(1));


        System.out.println(names);


        //自定义排序
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(names);

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        System.out.println(names);

        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        System.out.println(names);

        Collections.sort(names, (a, b) -> b.compareTo(a));

        System.out.println(names);

//新特性？

        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");

        names2.sort(Comparator.nullsLast(String::compareTo));

        System.out.println(names2);

        List<String> names3 = null;

        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));

        System.out.println(names3);


        System.out.println("e12".compareTo("b234"));


    }

}
