package com.yudianxx.basic.IO;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author huangyongwen
 * @date 2019/12/20
 * @Description
 */
public class ReadAndWriteDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("hello.txt");
        Path absolutePath = path.toAbsolutePath();
        File file = absolutePath.toFile();
        if (!file.exists()) {
            System.out.println("找不到该文件,正在创建文件");
            file.createNewFile();
        }

        String content = "你好呀，世界！";
        //写文件
//        writeFile(file, content);

        //读文件
//        readFile(file);
        System.out.println("1 ".length());

    }

    private static void writeFile(File file, String content) throws IOException {
        Writer writer = null;
        StringBuilder outputStream = new StringBuilder();
        try {
            outputStream = outputStream.append(content + "\r\n");
            writer = new FileWriter(file, true); //true表示追加
            writer.write(outputStream.toString());
//            throw new RuntimeException("wd");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    private static void readFile(File file) throws IOException {
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(new FileInputStream(file),"utf-8");//高效读取，不会存在乱码
//            InputStream buffered = new BufferedInputStream(new FileInputStream(file)); //可能会存在乱码
//            StringBuilder sb = new StringBuilder();
//            int n = 0;
//            while ((n = buffered.read()) != -1) {
//                sb.append((char)n);
//            }
//            String s  = sb.toString();
//            System.out.println("s:"+s);

//            因为一个汉字占两个字节,而当中英文混合的时候,有的字符占一个字节,
//                    有的字符占两个字节,所以如果直接用BufferedInputStream读字节,
//                    而数据比较长,没有一次读完的时候,很可能刚好读到一个汉字的前一个字节,
//                    这样,这个中文就成了乱码,后面的数据因为没有字节对齐,也都成了乱码.
//                    所以我们需要用BufferedReader来读取,它读到的是字符,所以不会读到半个字符的情况,不会出现乱码.
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(read);

        String lineTxt = null;
        while ((lineTxt = bufferedReader.readLine()) != null) {
            System.out.println(lineTxt);
        }
        read.close();
    }

}
