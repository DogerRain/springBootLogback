package com.yudianxx.basic.Abstract;

public class TestDemo {
    public static void main(String[] args) {
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00d);
        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00d);
        s.mailCheck();
        e.mailCheck();

//        Employee ss = new Employee("w") {
//            @Override
//            public String getName() {
//                return super.getName();
//            }
//        };
//        System.out.println(ss);



    }


//    Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00d);
//    抽象类和正常类的继承也是一样的，先从子类找该方法，找不到才会找父类
//     e.mailCheck();假如父类没有该方法，编译是会报错的

}
