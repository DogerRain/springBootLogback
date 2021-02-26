package com.hac.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author huangyongwen
 * @date 2021/2/26
 * @Description
 */
public class HaC {
    String name = "HaC";
    String sex = "男";
    int age = 26;

    public static void main(String[] args) {
        HaC haC = new HaC();
        System.out.println(ClassLayout.parseInstance(haC).toPrintable());
    }
}
