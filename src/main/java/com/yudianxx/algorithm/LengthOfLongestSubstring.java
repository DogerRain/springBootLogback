package com.yudianxx.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "abcabc";
//        String str = "abcabcd";
        System.out.println(new LengthOfLongestSubstring().noRepeatMaxLength(str));
    }

    public int noRepeatMaxLength(String str) {
        String[] strL = {str};
        Map<String,String> map= new LinkedHashMap<>();
        int length = 0;
        for (int i = 0; i < strL.length; i++) {
            String value = strL[i];
            if (map.containsKey(value)){
                return map.size();
            }else {
                map.put(value,i+"");
            }

        }
        return map.size();
    }
}
