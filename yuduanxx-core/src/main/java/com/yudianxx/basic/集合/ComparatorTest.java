package com.yudianxx.basic.集合;

/**
 * @author huangyongwen
 * @date 2020/9/25
 * @Description
 */

import lombok.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 第一种，实体类实现Comparable<T>接口，并实现 compareTo(T t) 方法，我们称为内部比较器。
 * <p>
 * 第二种，创建一个外部比较器，这个外部比较器要实现Comparator接口的 compare(T t1, T t2)方法。
 */
public class ComparatorTest {


    public static void main(String[] args) {
        Student xiaoming = new Student("xiaoming", 20);
        Student xiaohong = new Student("xiaohong", 21);
        Student xiaogang = new Student("xiaogang", 19);

        List<Student> list = new ArrayList<Student>();
        list.add(xiaohong);
        list.add(xiaoming);
        list.add(xiaogang);
        //因为Student类已经重写了compareTo方法
        System.out.println("已重写后的list --->>>" + list);

        Collections.sort(list, new Comparator<Student>() {
            @Override
            //升序
            public int compare(Student o1, Student o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        //自定义排序
        System.out.println("自定义排序list --->>>" + list);

    }
}

 class ComparatorTest2 implements Comparator<Student> {

    public static void main(String[] args) {
        Student xiaoming = new Student("xiaoming", 20);
        Student xiaohong = new Student("xiaohong", 21);
        Student xiaogang = new Student("xiaogang", 19);
        List<Student> list = new ArrayList<>();
        list.add(xiaohong);
        list.add(xiaoming);
        list.add(xiaogang);
        System.out.println("已重写后的list --->>>" + list);

        ComparatorTest2 comparatorTest = new ComparatorTest2();
        System.out.println("自定义比较--->>>"+comparatorTest.compare(xiaoming, xiaohong));

    }

    //重写compare方法，用于单独比较
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge().compareTo(o2.getAge());
    }


}

@Data
class Student implements Comparable<Student> {
    String name;
    Integer age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o2) {
        //降序
        return this.getAge().compareTo(o2.getAge());
    }
}