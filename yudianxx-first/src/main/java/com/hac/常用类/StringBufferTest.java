package com.hac.常用类;

import java.util.StringJoiner;

/**
 * @author huangyongwen
 * @date 2021/1/25
 * @Description
 */
public class StringBufferTest {
    public static void main(String[] args) {
//        useString();
//        userStringBuilder();
//        userStringJoiner();

        int i = 200;
        Integer k = 100;
        Integer j = new Integer(100);
        System.out.println(i == j);
        System.out.println(k == j);

    }

    static void useString() {
        String name = "HelloCoder ";
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            name += "HaC ";
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd - timeStart);
    }

    static void userStringBuilder() {
        StringBuilder sb = new StringBuilder("HelloCoder ");
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append("HaC ");
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd - timeStart);
    }

    static void userStringJoiner() {
        StringJoiner sj = new StringJoiner("-", "Welcome,", "!");
        sj.add("Hello");
        sj.add("HaC");
        sj.add("HelloCoder");
        System.out.println(sj);
    }

    static void useString2() {
        String name = "HelloCoder ";
        String resulet = "";
        for (int i = 0; i < 100000; i++) {
            StringBuffer sb = new StringBuffer("HaC ");
            sb.append(name);
            resulet = sb.toString();
        }

    }


}
