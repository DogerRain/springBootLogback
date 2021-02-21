package com.yudianxx.algorithm.LeetCodeHot100;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2021/2/21 14:35
 * @webSite https://rain.baimuxym.cn
 * @Description 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 *  
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 字符串中的第一个唯一字符387 {
    public static void main(String[] args) {
        String s = "dddccdbba";
//        int index = firstUniqChar(s);
        int index = firstUniqChar1(s);
        System.out.println(index);
    }


    /**
     * 我的解法，提交超出了时间限制
     * O(n^2)
     * 暴力
     *
     * @param s
     * @return
     */
    static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean flag = true;
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j] && (i != j)) {
                    flag = false;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * 我的解法，
     * 辅助Map，O(2n)
     *
     * @param s
     * @return
     */
    static int firstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        //统计每个字符出现的次数， key 为 字符 ，value 为 次数
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == null) {
                map.put(chars[i], 1);
            } else {
                int count = map.get(chars[i]);
                count++;
                map.put(chars[i], count);
            }
        }
        for (int i = 0; i <chars.length; ++i) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 官方1，使用HaspMap
     * @param s
     * @return
     */
    static int firstUniqChar2(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            //存放次数
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 奇技淫巧
     * @param s
     * @return
     */
    public int firstUniqChar3(String s) {
        for (int i = 0; i < s.length(); i++) {
            //lastIndexOf 返回指定字符在此字符串中最后一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

}
