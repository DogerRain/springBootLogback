package com.yudianxx.basic.序列化;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 * @author huangyongwen
 * @date 2021/3/8
 * @Description
 */
public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializeStudent();
        deserializeStudent();
    }

    //序列化
    static void serializeStudent() throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("F:\\HaC.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Student student1 = new Student("HaC", "HelloCoder", 30);
        oos.writeObject(student1);
        oos.flush();
        System.out.println("Student 对象序列化成功！");
        oos.close();
    }

    static void deserializeStudent() throws IOException, ClassNotFoundException {
        //反序列化
        FileInputStream fis = new FileInputStream("F:\\HaC.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student2 = (Student) ois.readObject();
        System.out.println(student2.getUserName() + " " +
                student2.getPassword() + " " + student2.getYear());
        System.out.println("Student 对象反序列化成功！");
    }
}

@Data
class Student implements Serializable {
    private static final long serialVersionUID = 3608451818006447637L;
    private String userName;
    private static String password = "123456";
    private transient int year = 1;

    Student(String userName, String password, int year) {
        this.userName = userName;
        this.password = password;
        this.year = year;
    }

    public String getPassword() {
        return this.password;
    }

}