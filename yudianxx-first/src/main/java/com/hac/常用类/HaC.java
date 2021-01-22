package com.hac.常用类;


import org.apache.commons.lang3.StringUtils;

/**
 * @author huangyongwen
 * @date 2021/1/20
 * @Description
 */
public class HaC {

    public static String WxName = "HelloCoder";

    String name11 = new String("HelloCoder");

    public static void main(String[] args) {
        String name = "1";

        WxName =WxName.toUpperCase();
        System.out.println(WxName);



        System.out.println(isBlank(name));
        System.out.println(isBlank2(name));

    }

    public static boolean isBlank(String str) {
        if (str != null && str.trim().length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isBlank2(String str) {
        return StringUtils.isBlank(str);
    }
}
