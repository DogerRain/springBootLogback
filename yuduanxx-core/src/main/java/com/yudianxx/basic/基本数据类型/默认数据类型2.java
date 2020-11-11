package com.yudianxx.basic.基本数据类型;

/**
 * @author huangyongwen
 * @date 2020/9/9
 * @Description
 */
public class 默认数据类型2 {


    public static void main(String[] args) {
        精度丢失();
        add();
        IntegerValueOf();
        DoubleValueOf();
    }


    void methodA(){
        int a =200;
        Integer b = new Integer(200);
        Integer c = 200;
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==c);
    }

    static void 精度丢失(){
        byte a = 5;
        int b =2;
        float c  = 6f;
        double d =0.03;
        double d2 =300.03;
        System.out.println(a/b); // 2  a会转化为int 类型
        System.out.println(b/c); // 0.33333334 b会转化为float类型
        System.out.println(a+d+d2); // 301.05999999999995 a会转化为double类型,但是结果理应是  301.06
    }
    public static double add() {
        double number1 = 1;
        double number2 = 20.2;
        double number3 = 300.03;
        double result = number1 + number2 + number3;
        System.out.println(result);
        return result;
    }

    public static void DoubleValueOf(){
        String str = "12.34";
        Double d = Double.valueOf(str);
        Double d2 = Double.valueOf(str);
        double d3 = Double.valueOf(str);
        System.out.println(d==d2); //false 这个和Integer还是有区别的
        System.out.println(d==d3); //true

    }
    public static void IntegerValueOf(){
        String str = "127"; // 127 下面两个都是true
        Integer d = Integer.valueOf(str);
        Integer d2 = Integer.valueOf(str);
        int d3 = Integer.valueOf(str);
        System.out.println(d==d2); //true
        System.out.println(d==d3); //true
    }
}
