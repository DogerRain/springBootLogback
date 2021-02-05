package com.hac.IO;

import java.io.*;


/**
 * @author huangyongwen
 * @date 2021/2/3
 * @Description
 */
public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        useInputStreamCopyFile(); //这种方法适用于任何文件
        //下面两种方法copy的文件变大了，因为是使用字符流处理的
        useBufferedReaderCopyFile(); //这种方法只适用于字符文件
        useFileReaderCopyFile(); //这种方法一步到位，只适用于字符文件

    }

    static void useInputStreamCopyFile() throws IOException {
        File file = new File("F:\\Hello1.txt");
        InputStream is = new FileInputStream(file);

        File file2 = new File("F:\\Hello1_copy1.txt");
        OutputStream os = new FileOutputStream(file2);

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        is.close();
        os.close();
    }


    static void useBufferedReaderCopyFile() throws IOException {
        File file = new File("F:\\Hello1.txt");
        InputStream is = new FileInputStream(file);
        Reader reader = new InputStreamReader(is);

        //创建字符流缓冲区，BufferedReader 的构造入参是一个 Reader
        BufferedReader bufferedReader = new BufferedReader(reader);

        File file2 = new File("F:\\Hello1_copy2.txt");
        OutputStream os = new FileOutputStream(file2);
        Writer writer = new OutputStreamWriter(os);
        //创建字符流缓冲区，BufferedWriter 的构造入参是一个 Writer
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        String line = null;
        //readLine()方法 是根据\n 换行符读取的
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            //这里要加换行
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    static void useFileReaderCopyFile() throws IOException {
        //使用FileReader、FileWriter 一步到位
        Reader reader = new FileReader("F:\\Hello1.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        Writer writer = new FileWriter("F:\\Hello1_copy3.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
