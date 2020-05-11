package com.yudianxx.algorithm;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class LengthOfLongestSubstring {
    public static void main(String[] args) {
//        String str = "abcabc";
        String str = "pwwkew";
//        String str = "abcabcbb";
//        String str = "bbbbb";
//        String str = "a";
//        System.out.println(new LengthOfLongestSubstring().noRepeatMaxLength(str));
//        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring1(str));
//        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring2(str));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring3(str));
//        System.out.println("s1111".substring(0,2).indexOf("1"));
//        System.out.println("s45c1".indexOf('c'));
//        int a = 'c';
//        System.out.println(a);
    }


    public int noRepeatMaxLength(String str) {
        char[] stringArr = str.toCharArray();
        if (stringArr.length == 1) {
            return 1;
        }
        Map<String, String> map = new LinkedHashMap<>();
        Map<String, String> map1 = new LinkedHashMap<>();
        int position = 0;
        for (int i = 0; i < stringArr.length; i++) {
            for (int j = i; j < stringArr.length; j++) {
                char value = stringArr[j];
                if (!map.containsKey(value + "")) {
                    map.put(value + "", i + "");
                } else {
                    String result = "";
                    for (String key : map.keySet()) {
                        result = result + key;
                    }
                    if (!map1.containsKey(map.size() + "")) {
                        map1.put(map.size() + "", result);
                    }
                    map.clear();
                    break;
                }
            }
        }
        System.out.println(map1);
        int Max = 0;
        for (String key : map1.keySet()) {
            position = Integer.parseInt(key);
            if (position > Max) {
                Max = position;
            }
        }
//        return map1.get(Max + "") + "";
        return Max;
    }


    //大佬的
    public int lengthOfLongestSubstring1(String s) {
        int l = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(l, i).indexOf(s.charAt(i)) != -1) {
                l = s.indexOf(s.charAt(i), l) + 1;
            }
            dp[i + 1] = Math.max(dp[i], i - l + 1);
        }
        return dp[s.length()];
    }

    public int lengthOfLongestSubstring2(String s) {
        int longest = 0;
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = pre + 1; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    pre = j;
                    break;
                }
            }
            longest = Math.max(i - pre, longest);
        }
        return longest;
    }

    //滑动窗口
    public int lengthOfLongestSubstring3(String s) {
        s = "pwwkewabw";
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        //i是开头，j是结束
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {
                //把开头remove，后面的字段会被覆盖的
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    //暴力破解
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

}
