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

        Age age = new Age(20);
        Student studentA = new Student(1, "HaC", age);
//        Student studentB = studentA; //引用拷贝
//        studentB.setId(2);   studentA studentB 都是执行同一个地址

        Student studentC = (Student) studentA.clone();
        System.out.println("------------拷贝后----------------");
        System.out.println("studentA:" + studentA);
        System.out.println("studentC:" + studentC);
        System.out.println(studentA == studentC);

//        studentC.setAge(new Age(19));
//
//        System.out.println("studentA:" + studentA);
//        System.out.println("studentA:" + studentC);

        System.out.println(System.identityHashCode(studentA.getAge()));
        System.out.println(System.identityHashCode(studentC.getAge()));

        System.out.println("------------Age类重新赋值----------------");

        age.setAge(22);
        System.out.println("studentA:" + studentA);
        System.out.println("studentC:" + studentC);



        Student studentD = (Student) studentC.clone();
        System.out.println("studentC:" + studentC);
        System.out.println("studentD:" + studentD);

    }


}

@AllArgsConstructor
@Data
public class Student implements Cloneable {
    int id;
    String name;
    Age age;
    @Override
    protected Object clone() throws CloneNotSupportedException {
            //浅拷贝
        return  super.clone();
    }
}

//@AllArgsConstructor
//@Data
//public class Student implements Cloneable {
//    int id;
//    String name;
//    Age age;
//
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        Student student = (Student) super.clone();
//        student.setAge((Age) student.getAge().clone());
//        return student;
//    }
//}

@AllArgsConstructor
@Data
class Age  implements Cloneable{
    int age;
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


