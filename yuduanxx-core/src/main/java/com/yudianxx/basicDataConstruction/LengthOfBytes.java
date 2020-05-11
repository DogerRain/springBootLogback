package com.yudianxx.basicDataConstruction;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class LengthOfBytes {
    public static void main(String[] args) {
        System.out.println(Charset.defaultCharset());//获取ide默认编码类型
        String s = new String("China ".getBytes());
        try {
            s = new String("中国".getBytes(), "GBK");  //9个字节
//            s = new String("中国".getBytes(), "UTF-8"); //6个字节
            System.out.println(Charset.defaultCharset());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] b = s.getBytes();
        System.out.println(s);
        System.out.println(b.length);

//        （1）GBK 编码（ide默认）时，每一个汉字占用 2 个字节，那么"中国"占 4 个字节。
//
//        （2）UTF-8 编码时，每一个汉字占用 3 个字节，那么"中国"占用 6 个字节。
//        char[] chars ={'China'};   //java中char只能是一个字符

    }
}
