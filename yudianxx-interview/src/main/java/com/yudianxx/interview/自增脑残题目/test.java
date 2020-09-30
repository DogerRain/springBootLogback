package com.yudianxx.interview.自增脑残题目;

public class test {
    public static void main(String[] args) {
        int a = 100, b = 50, c = a-- - b; //此时a的值是99
        int d = a-- - b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        count();
    }

    public static void count() {
        int a = 10;
        int i = 1;
        int k = 1;
        int b = 1;
        System.out.println(a++ + a--);
//        i = i++ + i;
        System.out.println(i++ + (++i)); //4
        System.out.println("i=" + i); //3
        System.out.println(k++ + k++); //左边是 1 ，但是 k赋值变成2；右边k是2，赋值变成3，但是 先 + 完再赋值，所以是 3 ，k也是3
        System.out.println("k=" + k); //3
        System.out.println(b++ + b); //左边值是 1 ，b赋值是2；右边 b是2，值也是2 ，所以是3
        System.out.println(b);
    }
}
