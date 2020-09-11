package com.yudianxx.basic.Java8新特性;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author huangyongwen
 * @date 2020/9/2
 * @Description
 */
public class ComparatorTest {

    @Data
    static class Fruit {
        private String name;
        private Integer price;


        @Override
        public String toString(){
            return "the fruit name is "+name+" and the price is "+price +"\n";
        }
    }

    public static void main(String[] args) {
        List<Fruit> list=new ArrayList<>();

        Fruit apple=new Fruit();
        apple.setName("apple");
        apple.setPrice(12);

        Fruit banana=new Fruit();
        banana.setName("banana");
        banana.setPrice(7);

        Fruit orange=new Fruit();
        orange.setName("orange");
        orange.setPrice(56);

        list.add(apple);
        list.add(banana);
        list.add(orange);



        Collections.sort(list,new Comparator<Fruit>() {
            @Override
            public int compare(Fruit f1,Fruit f2) {
                return f1.getPrice().compareTo(f2.getPrice()); //2 -1 就是降序了
                //String 类型 的 比较短字符串的前 length位 ，如果第一位的char值相等，就下一位，不相等就返回两个char值的 差
            }
        });

        System.out.println(list);

        Integer a = -2;
        Integer b =3;
        //Integer 类型的又是另外一个接口了
        System.out.println(a.compareTo(b));

    }

}
