package com.yudianxx.basic.IO;

import java.io.*;

public class 批量修改名字的 {

    public static void main(String[] args) throws IOException {
        //当前目录
        String dir = "G:\\学习资料\\java简历模板\\1、单页简历 150款\\5.活泼明朗18套单页";

        File currentDir = new File(dir);
        //        listDir(currentDir.getCanonicalFile(), 0);
        String[] files = currentDir.list();


        File[] filesArray = currentDir.listFiles();


        //放到新的目录
        String newDirStr = dir + "(修改后)";
        File newDir = new File(newDirStr);
        if (!newDir.exists()) {
            newDir.mkdir();
        }

        InputStream input = null;
        OutputStream output = null;

        try {


            for (File f : filesArray) {
                if (f.isDirectory()) {
                    continue;
                }


                //原文件名称
                String name = f.getName();

                //文件后缀名称，含点
                String suffix = name.substring(name.lastIndexOf("."));


                //新名称 ,根据不同的文件定制吧

                String newPreSubfixName = "HaC-应届生-求职简历-";
                String newName = newPreSubfixName + name;


                input = new FileInputStream(dir + "/" + name);
                output = new FileOutputStream(newDirStr + "/" + newName);

                byte[] buf = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buf)) > 0) {
                    output.write(buf, 0, bytesRead);
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
            output.close();
        }
    }


}
