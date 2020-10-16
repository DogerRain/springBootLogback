package com.yudianxx.basic.类加载过程;

/**
 * @author huangyongwen
 * @date 2020/10/9
 * @Description
 */
public class Base {
    private String baseName = "base";

    public Base() {
        callName(); //这里的callName()是调用子类的
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Sub extends Base {

        private String baseName = "sub";

        @Override
        public void callName() {
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        Base b = new Sub();
    }
}

//这不是内部类，这是类加载的顺序
//父类的静态代码块>子类的静态代码块>父类的代码块>父类的构造方法>子类的代码块>子类的构造方法

//因为 父类的构造方法 > 子类的代码块  ,
////所以子类还没有代码块 private String baseName = "sub"; baseName还没初始化，默认为null，如果是int则为0（baseName已经分配了空间，但是还没有值）


class Test {
    static int cnt = 6;
    static {
        cnt /= 3;
    }
    static {
        cnt += 9;
    }

    public static void main(String[] args) {
        System.out.println("cnt=" + cnt);
    }
}
//静态代码块是按顺序执行的