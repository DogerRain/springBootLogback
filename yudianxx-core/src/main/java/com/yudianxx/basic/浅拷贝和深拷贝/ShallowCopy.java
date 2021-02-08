package com.yudianxx.basic.浅拷贝和深拷贝;

import lombok.Data;

/**
 * @author huangyongwen
 * @date 2020/11/11
 * @Description
 */

//参考：https://blog.csdn.net/riemann_/article/details/87217229

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher1 = new Teacher();
        teacher1.setName("陈老师");
        teacher1.setAge(45);
        Student student1 = new Student();
        student1.setName("HaC");
        student1.setAge(20);
        student1.setTeacher(teacher1);

        //使用clone() 方法进行拷贝
        Student student2 = (Student) student1.clone();
        System.out.println("-------------浅拷贝后-------------");
        System.out.println("Student:" + student1);
        System.out.println("student2:" + student2);


        System.out.println("-------------修改老师的信息后-------------");
        // 修改老师的信息
        teacher1.setName("黄老师");
        //修改了引用类型，联动。 浅拷贝如果是引用数据类型，会copy 地址
        System.out.println("Student1的teacher为： " + student1.getTeacher().getName());
        System.out.println("student2的teacher为： " + student2.getTeacher().getName());

        //修改学生信息，浅拷贝如果是基本数据类型会copy一个对象
        student1.setAge(21);
        System.out.println("Student1的age为： " + student1.getAge());
        System.out.println("student2的age为： " + student2.getAge());
    }

    @Data
    static class Teacher implements Cloneable {
        private String name;
        private int age;

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    //学生的老师
    @Data
    static class Student implements Cloneable {
        private String name;
        private int age;
        private Teacher teacher;


        @Override
        public Object clone() throws CloneNotSupportedException {
            //浅拷贝的关键实现
//            Object object = super.clone();
//            return object;


            //深拷贝的关键实现
            Student student = (Student) super.clone();
            // 本来是浅复制，现在将Teacher对象复制一份并重新set进来
            student.setTeacher((Teacher) student.getTeacher().clone());
            return student;

        }

    }
}


