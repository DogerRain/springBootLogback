package com.hac.first;

/**
 * @author huangyongwen
 * @date 2021/1/6
 * @Description
 */
public class Test {
    String name = "HaC";
    char sex = '?';

    public boolean printName() {
        System.out.println("HaC");
        return true;
    }

    public int printSex() {
        System.out.println("?");
        return 1;
    }

    public void test() {

    }

    public static void main(String[] args) {

        Test test = new Test();
        Test test1 = new Test();
        System.out.println(test.hashCode());
        System.out.println(test1.hashCode());


    }

    static {
//        int[] intArrays = new int[5];
//        intArrays[0] = 100;
//        intArrays[1] = 200;
//        intArrays[5] =100; //? java.lang.ArrayIndexOutOfBoundsException
//        int[] intArrays ={100,200};
//        System.out.println(intArrays.length);
//
//        char[] charArrays ={'a','b','c'};


        int[][] intArrays = new int[3][3];
        intArrays[0][0] = 1;
        intArrays[0][1] = 2;
        intArrays[0][2] = 3;

        int sex = '男';
        System.out.println(sex);
//        char sexChar = '\u0030007';
        System.out.println();
        char sexStr = String.valueOf(sex).charAt(0);
        System.out.println(sexStr);
        int n2 = '中';
        System.out.println(n2);

        int a = 72;
        int b = 105;
        int c = 65281;
        String sexChar = "30007";
        // FIXME:
//        System.out.println((char));

        String s = String.format("%c%c%c", a, b, c);
        System.out.println(s);
        String hex = Integer.toHexString(30007);
        System.out.println(hex);
        char sexchachar = '\u7537';
        System.out.println(sexchachar);
    }

    static {
        int n2 = '男'; //字符 '男' 的Unicodde编码是 30007

        String hex = Integer.toHexString(30007);


    }

    static {
        String aa = "/";
        System.out.println(aa);

    }
}

