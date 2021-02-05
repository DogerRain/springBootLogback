package com.hac.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author huangyongwen
 * @date 2021/2/2
 * @Description
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        write();
        read1();
        read2();
    }

    static void write() throws IOException {
        FileWriter fileWriter = new FileWriter("F:\\Hello1.txt");
        //为防止乱码，可以这样写：
//        Writer fileWriter = new BufferedWriter(new OutputStreamWriter(
//                new FileOutputStream("F:\\Hello1.txt"), StandardCharsets.UTF_8));
        fileWriter.write("今天打工你不狠，明天地位就不稳\n" +
                "今天打工不勤快，明天社会就淘汰");
        fileWriter.flush();
        fileWriter.close();
    }

    static void read1() throws IOException {
        System.out.println("------一个一个char读-------");

        FileReader fileReader = new FileReader("F:\\Hello1.txt");
        int ch = 0;
        String str = "";
        //一个一个char读
        while ((ch = fileReader.read()) != -1) {
            str += (char) ch;
        }
        System.out.println(str);

    }

    static void read2() throws IOException {
        System.out.println("------char数组[]读-------");
        FileReader fileReader = new FileReader(new File("F:\\Hello1.txt"));
        int len = 0;
        char[] chars = new char[10];
        while ((len = fileReader.read(chars)) != -1) {
            //这种读有误
//            System.out.print(new String(chars));
            System.out.print((new String(chars, 0, len)));
        }
        fileReader.close();
    }
}
