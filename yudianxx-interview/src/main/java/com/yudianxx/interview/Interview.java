package com.yudianxx.interview;

public class Interview {
    public static void main(String[] args) {
        Interview interview = new Interview();
        interview.splitTest();
    }

    public void trueOrfalse() {
        boolean result = (true ? false : true) ? false : true;
        boolean result1 = true ? false : true ? false : true; //从右往左执行
        int i = 1;
        int k = 1;
        System.out.println(result);
        System.out.println(result1);
        System.out.println(true ? true : (false ? ++i : --i)); //如果前面为true，就直接执行前面了，不会执行后面的；false才会执行后面的
        System.out.println(false ? false : (true ? ++k : --k));
        System.out.println("————————————————————————————————");
        System.out.println(i);
        System.out.println(k);
    }

    public void splitTest() {
        String[] a = {"1", "2", "311按"};
        System.out.println(a.length);
        System.out.println(a[0].length());
        //数组是length(),字符串是length
        System.out.println("11,121".split(",").length);
        System.out.println("".split("")[0].length());
        System.out.println("12".split("").length); //"12".split("")返回的是一个数组，数组的长度参考第一个输出
    }
}
