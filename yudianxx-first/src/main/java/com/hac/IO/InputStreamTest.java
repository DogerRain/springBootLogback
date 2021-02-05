package com.hac.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author huangyongwen
 * @date 2021/2/1
 * @Description
 */
public class InputStreamTest {
    public static void main(String[] args) throws IOException {

        String fileName = "F:\\hello.txt";
        File file = new File(fileName);
        if (!file.exists()){
            file.mkdir();
        }
        FileInputStream fileInputStream = new FileInputStream(new File(fileName));
        int by = 0;
        byte []bytes = new byte[10];
        //一个字节数组的读出数据
        while ((by = fileInputStream.read(bytes)) != -1){
            for(int i = 0; i< by ; i++){
                System.out.print((char) bytes[i]);
            }
        }
        //关闭流
        fileInputStream.close();
    }
}
