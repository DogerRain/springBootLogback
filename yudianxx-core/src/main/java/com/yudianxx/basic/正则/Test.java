package com.yudianxx.basic.正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        getHttp();
//        StringAndNumbeer();
        getHttp2();
    }

    public void other() {
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
            System.out.println("???" + matcher2.group());
        }
    }

    public static void getHttp() {
//        String strber = "https://fms.res.meizu.com/dms/2020/05/08/041087f7-680e-40fe-a2cc-bcdb81931aa3.png";
        String strber = "https://fms.res.meizu.com/dms/2020/05/08/041087f7-680e-40fe-a2cc-bcdb81931aa3.png";
        String complie = "http(s)://(.*?)/";
        String result = "";
        Pattern pattern = Pattern
                .compile(complie);
        Matcher matcher = pattern.matcher(strber);
        if (matcher.find()) {
            result = matcher.group();
        }
        System.out.println(result);

//        String urlStart = strber.substring(strber.indexOf("//")+"//".length());
//        System.out.println(urlStart.substring(0,urlStart.indexOf("/")));
//
//        StringBuffer str = new StringBuffer("12");
//        str.append("222");
//        System.out.println(str);
    }

    public void matches(){
        String str = "agx";
        // 将原来的3个步骤封装到一步进行判断
        System.out.println(str.matches("[abc][defg][zyx]")); //符合返回true
    }

    public static void StringAndNumbeer(){
        String str = "261refdae612cC,./d/";
        // 将字符串内所有数字替换为-
        System.out.println(str.replaceAll("\\d", "-")); //\\d指所有数字
        // 将字符串内所有非数字去掉
        System.out.println(str.replaceAll("\\D", "")); //\\D指所有非数字
    }


    public static void  getHttp2(){
        String complie = "http(|s)://(.*?)/";
        String strber = "http://image.meizu.com/image/aider";
        String result = "";
        Pattern pattern = Pattern
                .compile(complie);
        Matcher matcher = pattern.matcher(strber);
        if (matcher.find()) {
            result = matcher.group();
        }
        System.out.println(result);
    }

}
