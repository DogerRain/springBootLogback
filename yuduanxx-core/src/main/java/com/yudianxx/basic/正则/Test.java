package com.yudianxx.basic.正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        /**
         * 取出 FoNuM04-TuPEHeXD7bYULFwl5xvp
         */
        String url = "http://images.liquma.com/FoNuM04-TuPEHeXD7bYULFwl5xvp?vframe/jpg/offset/1/w/173";


        System.out.println(
                url.substring(url.indexOf("com/") + "com/".length(), url.indexOf("com/") + "com/".length() + 28));


        //正则
//        String  key = "^com/[A-Za-z0-9]+[-]*+[//]+$";
//        String  key = "^com/[A-Za-z0-9]+[-]*+[//]+$";
//        Pattern pattern = Pattern.compile(key);
//        Matcher m = pattern.matcher(url);
//        if (m.find()) {
//            System.out.println(m.group(0));
//        }



        String s = "ssfsfhshfsfjjs13293016789yfdiyifdsafyasif";
        String regex = "[1][34579]\\d{9}";
        //将正则表达式转成正则对象
        Pattern pattern2 = Pattern.compile(regex);//正则对象与字符串匹配
        Matcher matcher2 = pattern2.matcher(s);
        while (matcher2.find()) {
            System.out.println("???"+matcher2.group());
        }

    }
}
