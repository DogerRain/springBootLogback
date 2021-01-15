package com.hac.third;

/**
 * @author huangyongwen
 * @date 2021/1/11
 * @Description
 */
public class HelloCoder {
    String name ;
    public void printName() {  //没有返回值方法
        System.out.println(name);
    }

    public int printSex() { //有返回值方法
        System.out.println("男");
        return 1;
    }

    public static void printWhatYouInput(String input) { //静态、带参数返回值方法
        System.out.println(input);
    }

    public static void main(String[] args) {
        HelloCoder helloCoder = new HelloCoder();
        helloCoder.printName();
        System.out.println(helloCoder.printSex());
        HelloCoder.printWhatYouInput("任意输入");
    }

}

class Test {
    public static void main(String[] args) {
        HelloCoder helloCoder = new HelloCoder();
        helloCoder.name = "HaC";
        helloCoder.printName();
    }
}