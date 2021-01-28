package com.hac.常用类;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author huangyongwen
 * @date 2021/1/26
 * @Description
 */
public class 时间类 {
    public static void main(String[] args) throws ParseException {
//        Date date1 = new Date(14686531L);
//        System.out.println(date1);
//        Date date2 = new Date();
//        System.out.println(date2.getTime());
//
//        test1();
//        test2();
//        test3();
        test4();


    }

    static void test1() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 将字符串转化为日期
        Date date = sdf.parse("2020-12-16 16:52:39");
        System.out.println(date);

        // 将date转化为字符串
        Date date2 = new Date();
        String str2 = sdf.format(date2);
        System.out.println(str2);

        System.out.println(sdf.format(1611628662034L));
    }

    static void test2() {
        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
        String year = String.valueOf(calendar.get(Calendar.YEAR));      //现在是哪一年
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);  //现在是几月份 ，月份从 0 开始
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));  //现在是月份的第几天
        String week = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK) - 1);  //现在是星期几 ，星期从 0 开始
        System.out.println("现在时间是：" + year + "年" + month + "月" + day + "日，星期" + week);
    }

    static void test3() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTime(simpleDateFormat.parse("2021-02-28"));
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        Date date = calendar.getTime();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd ").format(date));
    }

    static void test4() {
        SimpleDateFormat sdf = new SimpleDateFormat("现在是北京时间:y年M月d日 hh时m分s秒");
        System.out.println(sdf.format(new Date()));
    }


}

class TestTimeDiff {
    public static void main(String[] args) {
        System.out.println(getTimeDeffer("2015-10-21 10:48:22", "2015-10-27 22:48:23"));
    }

    public static String getTimeDeffer(String time1, String time2) {
        String result = "";
        if (StringUtils.isNotBlank(time1) && StringUtils.isNotBlank(time2)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                long dt1 = sdf.parse(time1).getTime();
                long dt2 = sdf.parse(time2).getTime();
                long dc = Math.abs(dt2 - dt1);
                long seconds = dc / 1000;
                long date = seconds / (24 * 60 * 60);     //相差的天数
                long hour = (seconds - date * 24 * 60 * 60) / (60 * 60);//相差的小时数
                long minute = (seconds - date * 24 * 60 * 60 - hour * 60 * 60) / (60);//相差的分钟数
                long second = (seconds - date * 24 * 60 * 60 - hour * 60 * 60 - minute * 60);//相差的秒数
                return (date == 0 ? "" : (date + "天")) + (hour == 0 ? "" : (hour + "小时")) + (minute == 0 ? "" : (minute + "分")) + (second == 0 ? "" : (second + "秒"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}