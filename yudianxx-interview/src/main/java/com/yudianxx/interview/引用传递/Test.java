package com.yudianxx.interview.引用传递;

public class Test {

    String str = "123";
    String[] strs = new String[]{"1", "2", "3"};

    public static void main(String[] args) {



        Test test = new Test();

        System.out.println("修改前 test.str  实参的值--->>>" + test.str);
        System.out.println("修改前 test.str  实参的hash地址--->>>" + test.str.hashCode());
        test.changeStr(test.str);
        System.out.println("修改后 test.str  实参的值--->>>" + test.str);
        System.out.println("修改后 test.str 实参的hash地址--->>>" + test.str.hashCode());

        System.out.println("——————————————————————————————————————————");

        System.out.println("修改前 test.strs  实参的值--->>>" + test.strs);
        System.out.println("修改前 test.strs  实参的hash地址--->>>" + test.strs.hashCode());
        test.changeStrs(test.strs);
        System.out.println("修改后 test.strs  实参的值--->>>" + test.strs);
        System.out.println("修改后 test.strs 实参的hash地址--->>>" + test.strs.hashCode());

    }

    private void changeStr(String str) {
        str = "321";
        System.out.println("str  形参的值--->>>" + str);
        System.out.println("str  形参的hash地址--->>>" + strs.hashCode());

    }

    private void changeStrs(String[] strs) {
        strs[0] = "0";
        System.out.println("strs  形参的值--->>>" + strs);
        System.out.println("strs  形参的hash地址--->>>" + strs.hashCode());
    }

}
