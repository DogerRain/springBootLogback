package com.yudianxx.basicDataConstruction;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class Student {
    String name;
    String age;
    Long userId;

    public Student(String name, String age, Long userId) {
        this.name = name;
        this.age = age;
        this.userId = userId;
    }

}

class HashSetTest {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        Student stu1 = new Student("A", "10", 1L);
        Student stu2 = new Student("B", "11", 2L);
        Student stu3 = new Student("C", "12", 3L);
        Student stu4 = new Student("D", "12", 4L);
        Student stu5 = new Student("D", "12", 4L);
        Student stu6 = new Student("E", "20", 5L);
        set.add(stu1);
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        set.add(stu4);
        set.add(stu5);
        set.add(stu6);
        System.out.println("-----------------HashSet----------------------");
        for (Student s : set) {
            System.out.println(s.getName() + "----" + s.getAge());
        }
        System.out.println("-----------------LinkedHashSet----------------------");
        LinkedHashSet<Student> set2 = new LinkedHashSet<>();
        set2.add(stu1);
        set2.add(stu1);
        set2.add(stu2);
        set2.add(stu3);
        set2.add(stu4);
        set2.add(stu5);
        set2.add(stu6);
        for (Student s2 : set2) {
            System.out.println(s2.getName() + "----" + s2.getAge());
        }
        System.out.println("-----------------HashMap----------------------");
        Map<String, Student> map = new HashMap<>();
        map.put("1", stu1);
        map.put("1", stu1);
        map.put("2", stu2);
        map.put("3", stu3);
        map.put("4", stu4);
        map.put("6", stu6);
        map.put("5", stu5);
        map.put("A", stu5);
        for (String key : map.keySet()) {
            Student s = map.get(key);
            System.out.println(key + ":" + s.getName() + "----" + s.getAge());
        }

        System.out.println("-----------------List----------------------\n");

        //list是有顺序的，先add的先被遍历出来
        List<Student> list = new ArrayList<>();
        list.add(stu5);
//        list.add(stu1);
        list.add(stu1);
        list.add(stu2);
//        list.add(stu5);

        System.out.println("-----------forEach遍历-------------");
        list.parallelStream().forEach(k -> {
            System.out.println(k);
        });
        System.out.println("-----------for遍历-------------");
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("-----------Iterator遍历-------------");
        //取list第一个元素
//        System.out.println(list.iterator().next());
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        new HashSetTest().method(list);
    }

    void method(List<Student> list) {
        //Collectors.toMap是设置一个map的key，不能重复
        Map<Long, Student> productIdAndDetailMap = list.parallelStream().collect(Collectors.toMap(Student::getUserId, k -> {
            return k;
        }));
        System.out.println(productIdAndDetailMap);
        Map<String, Student> productIdAndDetailMap2 = list.parallelStream().collect(Collectors.toMap(Student::getName, k -> {
            return k;
        }));
        System.out.println(productIdAndDetailMap2);
    }
}
