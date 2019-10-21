package com.yudianxx.basic.basicDataStructure;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetTest {
    //HashSet实现set接口，实际上是由hashMap实现的，所以不保证遍历顺序，并且允许使用null，时间复杂度和hashMap一样，为O(1),不超过O(n)
//    set不允许重复的元素，如果set已经有重复的元素，会返回false
//    案例，给定一个字符串，返回第一个重复的字符
    public static void main(String[] args) {
        String s ="abcdfkga";
        String a =findFirstRepeatedChar(s);
        System.out.println(a);
    }


    public static String findFirstRepeatedChar(String string) {
        if (Objects.isNull(string) || string.isEmpty()) {
            return null;
        }
        char[] chars = string.toCharArray();
        Set<Character> hashSet = new HashSet<Character>();
        for (char ch : chars) {
            if (hashSet.contains(ch)) {
                return ch + "";
            }
            hashSet.add(ch);
        }
        return null;
    }
}
