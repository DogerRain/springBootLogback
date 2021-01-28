package com.yudianxx.basic.集合.自定义排序;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangyongwen
 * @date 2021/1/28
 * @Description
 */

//class Car {
//    String number;
//    String carName;
//
//    Car(String number, String carName) {
//        this.number = number;
//        this.carName = carName;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "number='" + number + '\'' +
//                ", carName=" + carName +
//                '}';
//    }
//}

public class ComparableTest {
    public static void main(String[] args) {
//        String[] strArr = {"A", "B", "C", "E", "D"};
//        Arrays.sort(strArr);
//        for (String string : strArr) {
//            System.out.print(string + ";");
//        }

        Student xiaoha = new Student("小哈", 20);
        Student erha = new Student("二哈", 19);
        Student daha = new Student("大哈", 25);
//        Student[] studentArray = new Student[]{xiaoha, erha, daha};
//        //报错，因为没有自定义的比较规则
//        Arrays.sort(studentArray);
//        for (Student student : studentArray) {
//            System.out.println(student);
//        }


        List<Student> studentList = new ArrayList<>();
        studentList.add(xiaoha);
        studentList.add(erha);
        studentList.add(daha);
        System.out.println(studentList);

    }


    static class Student implements Comparable<Student> {
        String name;
        Integer age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public int compareTo(Student o2) {
            //降序
            return this.getAge().compareTo(o2.getAge());
        }

        @Override
        public String toString() {
            return "Car{" +
                    "名字='" + name + '\'' +
                    ", 年龄=" + age +
                    '}';
        }
    }
}
