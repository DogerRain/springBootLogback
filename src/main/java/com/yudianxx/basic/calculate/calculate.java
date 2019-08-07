package com.yudianxx.basic.calculate;


//k++ 最后才执行++；++k是先运算得到k再执行，
public class calculate {
    public static void main(String[] args) {
        int i=0;
        int j=1;
        int k=2;
        System.out.println(i++);
        System.out.println(++i);
        System.out.println(i+1);
        method(k+2);
        method(k++);
        method(++k);
    }
    static void method(int in){
        System.out.println(in);
    }
}
