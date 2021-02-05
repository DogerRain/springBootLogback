package com.hac.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author huangyongwen
 * @date 2021/2/2
 * @Description
 */
public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
        writeFile(); //单个字节写、字节数字写
        readFile1();//单个字节读取
        readFile2();//字节数组读取
        readFile3();//一次性读取
    }

    static void writeFile() throws IOException {
        //1、第一种方法写，单个字节写
        //会自动创建文件，目录不存在会报错， true 表示 追加写，默认是false
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\hello.txt", false);
        //往文件里面一个字节一个字节的写入数据
        fileOutputStream.write((int) 'H');
        fileOutputStream.write((int) 'a');
        fileOutputStream.write((int) 'C');

        //2、第二种方法写 字节数组写
        String s = " HelloCoder";
        //入文件里面一个字节数组的写入文件，文件为UTF_8格式
        fileOutputStream.write(s.getBytes(StandardCharsets.UTF_8));
        //刷新流
        fileOutputStream.flush();
        //关闭流
        fileOutputStream.close();
    }

    static void readFile1() throws IOException {
        //1、第一种读的方法，但字节读
        System.out.println("------一个字节读------");
        //传文件夹的名字来创建对象
        FileInputStream fileInputStream = new FileInputStream("F:\\hello.txt");
        int by = 0;
        //一个字节一个字节的读出数据
        while ((by = fileInputStream.read()) != -1) {
            System.out.print((char) by);
        }
        //关闭流
        fileInputStream.close();
    }

    static void readFile2() throws IOException {
        //2、第二种读的方法，字节数组读
        System.out.println();
        System.out.println("------字节数组读------");
        FileInputStream fileInputStream = new FileInputStream("F:\\hello.txt");
        //通过File对象来创建对象
        fileInputStream = new FileInputStream(new File("F:\\hello.txt"));
        int by = 0;
        byte[] bytes = new byte[10];
        //一个字节数组的读出数据，高效
        while ((by = fileInputStream.read(bytes)) != -1) {
            for (int i = 0; i < by; i++) {
                System.out.print((char) bytes[i]);
            }
        }
        //关闭流
        fileInputStream.close();
    }

    static void readFile3() throws IOException {
        //3、第三种读方法，一次性读
        System.out.println();
        System.out.println("------一次性读文件------");
        FileInputStream fileInputStream = new FileInputStream("F:\\hello.txt");
        fileInputStream = new FileInputStream(new File("F:\\hello.txt"));
        //一次性读文件
        int iAvail = fileInputStream.available();
        int by = 0;
        byte[] bytesAll = new byte[iAvail];
        while ((by = fileInputStream.read(bytesAll)) != -1) {
            for (int i = 0; i < by; i++) {
                System.out.print((char) bytesAll[i]);
            }
        }
        fileInputStream.close();
    }
}
