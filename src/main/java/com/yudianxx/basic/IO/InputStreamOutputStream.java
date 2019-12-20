package com.yudianxx.basic.IO;

import java.io.*;

/**
 * @author huangyongwen
 * @date 2019/12/20
 * @Description
 */
public class InputStreamOutputStream {
    public static void main(String[] args) throws Exception {
        write();
        read();
    }

    public static void write() throws IOException {
        String str = "输入。\r\n11"; //字符流
        try (OutputStream output = new FileOutputStream("E:\\projet\\springBootLogback\\hello.txt",true)){
            output.write(str.getBytes()); //字符转字节
        }

    }

    public static void read() throws Exception {
        String s;
        try (InputStream input = new FileInputStream("E:\\projet\\springBootLogback\\hello.txt")) {
            int n;
            StringBuilder sb = new StringBuilder();
            byte[] b = new byte[1024];
            while ((n = input.read(b)) != -1) {
                sb.append(new String(b, 0, n, "utf-8"));
            }
            s = sb.toString();
        }
        System.out.println(s);
    }
}
