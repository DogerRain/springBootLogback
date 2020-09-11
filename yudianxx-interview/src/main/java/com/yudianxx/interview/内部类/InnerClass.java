package com.yudianxx.interview.内部类;

/**
 * @author huangyongwen
 * @date 2020/9/9
 * @Description
 */

// 这个就是外部类，最大的类，只能使用 public、default、 abstract、finall 修饰
public class InnerClass {
    private String data = "shuju";

    //内部类
    //成员内部类可以拥有private访问权限、protected访问权限、public访问权限、默认访问权限。如用private修饰，则只能在外部类的内部访问。
    class Inner{
        public void getOutterData(){
            System.out.println(data);
        }
        private void getOutterData2(){
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        new InnerClass().new Inner().getOutterData();
        new A();
    }

}
