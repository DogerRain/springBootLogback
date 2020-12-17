package com.yudianxx.interview;

import org.apache.commons.lang3.StringUtils;

public class 数组 {
    public static void main(String[] args) {
        b();

    }

    private static void b() {
        String sysRegion = null;
        String[] strings= new String[]{};
        if (StringUtils.isNotBlank(sysRegion)){
            strings = sysRegion.split(",");
        }
        for (String region : strings) {
            System.out.println(region);
        }
    }

    static void a (){
        int arr1[] = new int[10]; /*开辟了一个长度为3的数组  下标从0开始*/
//int[] arr1 = new int[3]; //也可以这样写
        arr1[0] = 10; // 第一个元素
        arr1[1] = 20; // 第二个元素
        arr1[2] = 30; // 第三个元素

//初始化可以这样写
        String[] arr2=new String[10];
        arr2[0]=null;
        arr2[1]="HaC";

        int[] arr3=new int[]{1,2,3,4,5,6,7,22};

        char[] arr4=new char[1];

        System.out.println(arr1.length);

        System.out.println(arr2[0]);
        System.out.println(arr2[1].length());
        System.out.println(arr2[2]);

        System.out.println(arr4.hashCode());
        System.out.println(arr4[0]);
        System.out.println(arr4.hashCode());

        String[] strArray = {"ab","cd"};
        System.out.println(strArray.hashCode());
        strArray = new String[5];
        System.out.println(strArray.hashCode());
    }
}
