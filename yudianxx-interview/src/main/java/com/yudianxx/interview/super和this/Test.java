package com.yudianxx.interview.super和this;

public class Test {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
//        System.out.println(new A(5).getValue());
    }

    static class A {
        protected int value;

        public A(int v) {
           setValue(v); //这个setValue是调用子类的setValue 方法
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            try {
                value++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }

    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() - 3); //setValue 肯定是调用子类的 setValue
        }

        @Override
        public void setValue(int value) {
            super.setValue(2 * value);
        }

    }


}
