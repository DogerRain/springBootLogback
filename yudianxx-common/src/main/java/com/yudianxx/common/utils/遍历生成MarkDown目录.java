package com.yudianxx.common.utils;

import java.io.File;

/**
 * @author huangyongwen
 * @date 2021/2/22
 * @Description
 */
public class 遍历生成MarkDown目录 {
    public static void main(String[] args) {
        String dir = "F:\\笔记\\LearnJavaToFindAJob（Java面试题）\\docs\\articles";
        File file = new File(dir);
        generateCategory(file, 1);
    }

    static void generateCategory(File file, int level) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();//注意:这里只能用listFiles()，不能使用list()
            //files下的所有内容，可能是文件夹，也可能是文件，那么需要一个个去判断是文件还是文件夹，这个判断过程就是这里封装的方法
            //因此可以调用自己来判断，实现递归
            for (File flies2 : files) {
                String name = flies2.getName();
                if (flies2.isDirectory()) {
                    if (!name.equals("picture")) {
                        System.out.println("- " + name);
                        generateCategory(flies2, level);
                    }
                } else {
                    System.out.println(getspace(2) + "[" + flies2.getName().substring(0, flies2.getName().length() - 3) + "]" +
                            "(" + "articles"  + getParaentString(flies2) +"\\"+ flies2.getName() + ")");
                }
            }
        }
    }

    private static String getspace(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append("- ");
        for (int x = 1; x < level; x++) {
            sb.insert(0, "  ");
        }
        return sb.toString();
    }

    private static String getParaentString(File file) {
        String name = file.getParent();
        return name.substring(name.lastIndexOf('\\'));
    }

}
