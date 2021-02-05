package com.hac.IO;

import java.io.*;

/**
 * @author huangyongwen
 * @date 2021/2/3
 * @Description
 */
public class InputStrem与BufferenInputStream复制文件 {
    public static void main(String[] args) throws IOException {
        useInputStreamCopyFile(); //缓冲流复制文件
        useBufferenInputStream(); //普通流复制文件
    }

    static void useInputStreamCopyFile() throws IOException {
        File file = new File("F:\\杨超越.png");
        InputStream is = new FileInputStream(file);

        File file2 = new File("F:\\杨超越_copy.png");
        OutputStream os = new FileOutputStream(file2);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1) {
            os.write(bytes);
        }
        is.close();
        os.close();
    }

    static void useBufferenInputStream() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\杨超越.png"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\杨超越_copy2.png"));
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();
    }
}
