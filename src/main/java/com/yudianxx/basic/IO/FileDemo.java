package com.yudianxx.basic.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author huangyongwen
 * @date 2019/12/19
 * @Description
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
//        File f = new File("C:\\Windows\\notepad.exe");
        FileDemo fileDemo = new FileDemo();
//        fileDemo.createFile();
//        fileDemo.listFile("E:\\projet\\springBootLogback\\target\\classes\\com\\yudianxx\\springBootDemo");

        //当前目录
        File currentDir = new File(".");
        //        listDir(currentDir.getCanonicalFile(), 0);
        String[] files = currentDir.list();
        for (String s : files) {
            System.out.println(s);
        }


    }

    public void filepath() throws IOException {
        //        File对象有3种形式表示的路径，一种是getPath()，返回构造方法传入的路径，
//        一种是getAbsolutePath()，返回绝对路径，
//        一种是getCanonicalPath，它和绝对路径类似，但是返回的是规范路径。
        File f = new File(".\\test.txt");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());

    }

    public void newFile() {
        File f1 = new File("E:\\projet\\springBootLogback");
        File f2 = new File("E:\\projet\\springBootLogback\\notepad.exe");
        File f3 = new File("E:\\projet\\springBootLogback\\nothing");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());
    }

    public void createFile() throws IOException {
        File f2 = new File("E:\\projet\\springBootLogback\\notepad.exe");
        if (!f2.exists()) {
            f2.createNewFile();
        }
        File f3 = new File("E:\\projet\\springBootLogback\\nothing");
        if (!f3.exists()) {
            f3.createNewFile();
        }
    }

    public void listFile(String fileSrc) {
        File f1 = new File(fileSrc);
        File[] fs1 = f1.listFiles();//列出所有文件和子目录
        for (File file : fs1) {
            if (file.isDirectory()) {
                listFile(file + "");
            }
            if (file.isFile()) {
                System.out.println(file);
                System.out.println();
                System.out.println(file.getParentFile().getParent().substring((file.getParentFile().getParent().lastIndexOf("\\") + 1)));
            }
        }
    }


    static void listDir(File dir, int level) {

        File[] fs = dir.listFiles();

        if (fs != null) {

            for (File f : fs) {

                if (f.isDirectory()) {

                    printSpace(level);

                    System.out.println(f.getName() + "/");

                    listDir(f, level + 1);

                } else {

                    printSpace(level);

                    System.out.println(f.getName());

                }

            }

        }

    }

    static void printSpace(int level) {

        for (int i = 0; i < level; i++) {

            System.out.print("  ");

        }

    }

    public void pathFile() {
        Path p1 = Paths.get("hello.txt"); // 构造一个Path对象
        System.out.println(p1);
        Path p2 = p1.toAbsolutePath(); // 转换为绝对路径
        System.out.println(p2);
        Path p3 = p2.normalize(); // 转换为规范路径
        System.out.println(p3);
        File f = p3.toFile(); // 转换为File对象
        System.out.println(f);
        for (Path p : Paths.get("..").toAbsolutePath()) { // 可以直接遍历Path
            System.out.println("  " + p);
        }
    }

}
