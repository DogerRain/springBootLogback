package com.hac.first;

/**
 * @author HaC
 * @date 2021/1/6
 * @Description 这是一个教程的基础类
 */
public class HelloCoder {
    private String name = "HaC"; //private 声明变量

    protected void printName() { //protected 声明方法
        System.out.println(name);
    }

    /**
     * 这是一个main方法
     * @param args
     */
    public static void main(String[] args) {

    }

    static {
        int x = 0x7f; //可以使用16进制，其实就是 127
        System.out.println(x);
        int y = x; // 新建一个 y 变量，赋值为 x，即 127
        x = 128;  // x 重新赋值
        System.out.println(x); //打印x
        System.out.println(y);//打印y ， y并没有受到x重新赋值的影响
        System.out.println("\uD83D\uDE0A".length());
    }

    static {
        int x = 5;
        int y = 2;
        char z = '我';
        System.out.println(x + y); //7
        System.out.println(x - y); //3
        System.out.println(x * y); //10
        System.out.println(x / y); //2
        System.out.println(x % y); //1
        System.out.println(x + z); //1

        x = x + 1; //
        System.out.println(x);


    }

    static {
        double x = 5.2d;
        double y = 2.1d;
        long xx = 12l;
        System.out.println(x + y);

    }

    static {
        float x = 5F;
        double y = 2D;
//        float z = 10.0;
    }

    static {
        int x = 1;
        int y = x++;
        System.out.println(x);
        System.out.println(y);
    }

    static {
        int x = 1;
        int y = ++x;
        System.out.println(x);
        System.out.println(y);
    }

    static {
        int x = 1;
        double y = x;
        System.out.println(y); // 1.0


    }

    static {
        double x = 1.2;
        int y = (int) x;
        System.out.println(y); // 1
    }

    static {
        byte x = 20;
        x += 30;// 相当于 x = (byte)(x+20);
        System.out.println(x);

        int k = 5;
        float z = 2.5f;
        double m = k * z;
        System.out.println(m);

    }

    static {
        int x = 1;
        x += 2; //相当于 x = x + 2
        System.out.println(x); // 3
    }

    static {
        boolean flag = 1 > 0 && 2 >= 2;
        System.out.println(flag);

        System.out.println(true | false);
        System.out.println(1 ^ 0);


        boolean a = true;
        boolean b = false;
        System.out.println(!a);      //false
        System.out.println(a && b && a); //false
        System.out.println(a || b || b); //true

    }

    static {
        System.out.println(0 ^ 0);
    }

    static {
        int x = 1;
        int y = 2;
        String str = "HelloCoder";
        System.out.println(x + y + str); // 3HelloCoder
        System.out.println(str + x + y); // HelloCoder12
        System.out.println(x + str + y); // 1HelloCoder2
    }

    static {
        String str = 2 > 1 ? "大于1" : "小于1";
        System.out.println(str);
        int i = 1;
        System.out.println(1 + 2 * 4 / i++);
    }


    static {
        String str = "HelloCoder";
        System.out.println(str.length()); //10 长度
        System.out.println(str.hashCode()); //420845203  hash地址，唯一
        System.out.println(str.indexOf("C")); //5  字母C 的索引
    }

    int x = 1;
    static int y = 2;
    static final int z = 3;

    static {
        int x = 5;
        while (x >= 1) {
            System.out.println("x的值：" + x);
            x--;
        }
    }

    static {
        /*
         * 这是一行平淡无奇的注释
         * 这也是一行平淡无奇的注释
         * //嵌套单行注释
         */
        String name = "HaC";  //姓名

    }

}
