package com.hac.常用类;

import java.io.File;
import java.io.IOException;

/**
 * @author huangyongwen
 * @date 2021/2/1
 * @Description
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        String filePath2 = "F:\\Hello\\hello.txt";
        File file2 = new File(filePath2);
        File fileParent2 = file2.getParentFile();
        if (!fileParent2.exists()) {
            fileParent2.mkdirs();
        }
        file2.createNewFile();
    }
}

class FileTest2 {
    public static void main(String[] args) {

    }

    static void error1() {
        String fileName1 = "F:\\HelloCoder\\hello.txt";
        File file = new File(fileName1);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}