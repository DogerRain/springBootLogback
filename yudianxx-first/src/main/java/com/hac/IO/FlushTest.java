package com.hac.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author huangyongwen
 * @date 2021/2/2
 * @Description
 */
public class FlushTest {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("F:\\Hello1.txt");
        FileWriter fileWriter = new FileWriter("F:\\Hello2.txt");
        int readerCount = 0;
        //一次读取1024个字符
        char[] chars = new char[1024];
//        while (-1 != (readerCount = fileReader.read(chars))) {
        while (-1 != (readerCount = fileReader.read())) {
//            fileWriter.write(chars, 0, readerCount);
            fileWriter.write(readerCount);
        }
//        fileWriter.flush();
//        fileWriter.close();
    }


}

class FlushTest2{
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("F:\\Hello3.txt");
        fileWriter.write("今天打工你不狠，明天地位就不稳\n" +
                "今天打工不勤快，明天社会就淘汰");
    }
}