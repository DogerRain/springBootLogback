package com.yudianxx.basic.IO;

import java.io.*;

/**
 * @author huangyongwen
 * @date 2020/1/6
 * @Description
 */
public class ReadTxt {
    public static void main(String[] args) {
        String txt = "当前操作-----------》》sdk调用proxy,耗时--------》》251 毫秒";

        String[] context = {"sdk调用proxy", "调用方法：putObject，操作描述：文件上传",
                "调用方法：preHandle，操作描述：拦截器", "当前操作-----------》》获取组、配置,耗时"
                , "上传到（阿里）"
                , "上传到（七牛云）", "上传到（mfs）"};

//        System.out.println(txt.substring(txt.indexOf("耗时--------》》") + "耗时--------》》".length(), txt.indexOf(" 毫秒")));
        ReadTxt readTxt = new ReadTxt();
        try {
            for (int i = 0; i < context.length; i++) {
                System.out.println(readTxt.read(context[i]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String read(String s) throws IOException {
        String filePath = "C:\\Users\\huangyongwen\\Desktop\\服务器\\gemini\\";
//        String fileName = "300k_100Thread.txt";
        String fileName = "core.log";
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(new FileInputStream(filePath + fileName), "utf-8");//高效读取，不会存在乱码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        long max = 0;
        long min = 100000;
        long avg = 0;
        int i = 0;
        while ((lineTxt = bufferedReader.readLine()) != null) {
            if (lineTxt.contains(s)) {
//            if (lineTxt.contains(s)) {
//                System.out.println(lineTxt);
//                String time = lineTxt.substring(lineTxt.indexOf("文件上传，共耗时： ") + "文件上传，共耗时： ".length(), lineTxt.indexOf(" 毫秒"));
                String time = lineTxt.substring(lineTxt.indexOf("耗时--------》--》") + "耗时--------》--》".length(), lineTxt.indexOf(" 毫秒"));
                long timeLong = Long.parseLong(time);
                avg += timeLong;
                if (timeLong > max) {
                    max = timeLong;
                }
                if (timeLong < min) {
                    min = timeLong;
                }
                i++;
            }
        }
//        System.out.println("max=" + max + ",min=" + min + ",avg=" + avg / i + ",共计 " + i + "个");
        read.close();
        return s + ",max=" + max + ",min=" + min + ",avg=" + avg / i + ",共计 " + i + "个";
    }


}
