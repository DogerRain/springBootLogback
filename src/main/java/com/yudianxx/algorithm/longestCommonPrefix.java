package com.yudianxx.algorithm;

/**
 * @Author: Administrator
 * @Date: 2019/8/15  23:35
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Param:
 * @return:
 */
public class longestCommonPrefix {

    public static void main(String[] args) {
        String[] inputStr = {"flower", "flow", "flight"};
//        System.out.println(new longestCommonPrefix().longestCommonPrefix(inputStr));
    }

    public String longestCommonPrefix(String[] strs) {
        int k = 0;
        char a=strs[0].charAt(0);
//        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        for (int i = 0; i < strs.length; i++) {
            k=strs[i].length();
            for (int j=0;j<strs[i].length();j++){

                if (k>strs[i].length()){

                }
                if (a!=strs[i].charAt(i)){
                    return "";
                }else {
                    a=strs[i].charAt(i);

                }
            }


        }

        return "";
    }
}
