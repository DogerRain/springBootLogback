package com.yudianxx.basic.浅拷贝和深拷贝;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author huangyongwen
 * @date 2020/11/11
 * @Description
 */
class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        String[] hobbies = new String[]{"打篮球", "码代码"};
        Student studentA = new Student(1, "HaC", hobbies);

//        System.out.println("------------引用拷贝----------------");
//        Student studentB = studentA; //复制引用，这是对象地址赋值
//        studentB.setId(2);   //studentA studentB 都是指向同一个地址
//        hobbies[0] = "看电影";
//        System.out.println("studentA:" + studentA);
//        System.out.println("studentC:" + studentB);
//        System.out.println("studentA == studentB 的结果："+(studentA == studentB));

                System.out.println("------------深拷贝----------------");
//        System.out.println("------------浅拷贝----------------");
        Student studentC = (Student) studentA.clone();
        System.out.println("studentA:" + studentA);
        System.out.println("studentC:" + studentC);
        System.out.println("studentA == studentC 的结果：" + (studentA == studentC));
        studentA.setName("哈希");
        hobbies[0] = "看电影";
        System.out.println("studentA:" + studentA);
        System.out.println("studentC:" + studentC);


    }
}

@AllArgsConstructor
@Data
public class Student implements Cloneable {
    int id;
    String name;
    String[] hobbies;

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        //浅拷贝
//        return super.clone();

//         深拷贝，现在将String[]复制一份并重新set进来
        Student student = (Student) super.clone();
        student.setHobbies(student.getHobbies().clone());
        return student;
    }
}

