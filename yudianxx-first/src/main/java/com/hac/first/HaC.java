package com.hac.first;

/**
 * @author huangyongwen
 * @date 2021/1/6
 * @Description
 */
public class HaC {
    static String name = "HaC"; //静态变量

    public static void main(String[] args) {


        String str1 = " 我是HaC，";
        String str2 = " 我的公众号:\"HelloCoder\" ";
        String str3 = str1 + str2;
        System.out.println(str3);

//        一步到位
        String str4 =  " 我是HaC，" + " 我的公众号:\"HelloCoder\" ";
        System.out.println(str4);



    }
    static   //静态代码块
    {
        System.out.println(name);
    }

    //静态方法
    public static void printName(){
        System.out.println(name);
    }


}
