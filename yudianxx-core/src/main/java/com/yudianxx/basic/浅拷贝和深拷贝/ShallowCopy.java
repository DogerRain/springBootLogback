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
        Teacher teacher = new Teacher();
        teacher.setName("riemann");
        teacher.setAge(28);

        Student1 student1 = new Student1();
        student1.setName("edgar");
        student1.setAge(18);
        student1.setTeacher(teacher);

        Student1 student2 = (Student1) student1.clone();
        System.out.println("-------------拷贝后-------------");
        System.out.println("student1:"+student1);
        System.out.println("student2:"+student2);

        System.out.println("-------------修改老师的信息后-------------");
        // 修改老师的信息
        teacher.setName("jack");


        System.out.println("student1的teacher为： " + student1.getTeacher().getName());
        System.out.println("student2的teacher为： " + student2.getTeacher().getName());


        //修改学生信息
        student1.setAge(2);

        System.out.println("student1的teacher为： " + student1.getAge());
        System.out.println("student2的teacher为： " + student2.getAge());
    }
}
@Data
class Teacher implements Cloneable {
    private String name;
    private int age;

}

@Data
class Student1 implements Cloneable {
    private String name;
    private int age;
    private Teacher teacher;


    @Override
    public Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        return object;
    }
}
