package com.yudianxx.basic.IO;

import java.util.StringJoiner;

/**
 * @author huangyongwen
 * @date 2020/12/3
 * @Description
 */
public class StringJoinerTest {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",");

        stringJoiner.add("12");

        System.out.println(stringJoiner.toString());

    }
}
