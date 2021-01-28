package com.yudianxx.basic.集合.自定义排序;

import java.util.*;

/**
 * @author huangyongwen
 * @date 2021/1/28
 * @Description
 */


public class ComparatorTest {

    static class Student {
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
        public String toString() {
            return "Car{" +
                    "名字='" + name + '\'' +
                    ", 年龄=" + age +
                    '}';
        }

    }

    static class SortComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            //降序
            return o2.getAge().compareTo(o1.getAge());
        }
    }

    public static void main(String[] args) {
        Student xiaoha = new Student("小哈", 20);
        Student erha = new Student("二哈", 19);
        Student daha = new Student("大哈", 25);
        Student[] studentArray = new Student[]{xiaoha, erha, daha};

//        //报错，因为没有自定义的比较规则
//        Arrays.sort(studentArray, new sortComparator());
//        for (Student student : studentArray) {
//            System.out.println(student);
//        }

//
        List<Student> studentList = new ArrayList<>();
        studentList.add(xiaoha);
        studentList.add(erha);
        studentList.add(daha);
        System.out.println(studentList);
        Collections.sort(studentList,new SortComparator());
        System.out.println(studentList);


        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            //降序
            public int compare(Student o1, Student o2) {
                return o2.getAge().compareTo(o1.getAge());
            }
        });
        System.out.println(studentList);
    }

}
