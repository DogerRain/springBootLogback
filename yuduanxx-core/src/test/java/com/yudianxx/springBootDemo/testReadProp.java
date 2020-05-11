package com.yudianxx.springBootDemo;

import com.yudianxx.springBootDemo.Utils.JavaMailUtil;
import com.yudianxx.springBootDemo.Utils.PropertiesUtil;
import org.junit.Test;


/**
 * Created by GWCheng on 2015/12/29.
 */
public class testReadProp{

//    @Test
    public void testReadProp() {
        PropertiesUtil.readProperties("config.properties");
        System.out.println(PropertiesUtil.getProperty("key"));
//        System.out.println(PropertiesUtil.getProperty("pwd"));
    }

    @Test
    public void testReadProp1() {
        try {
            JavaMailUtil.sendMail("message","主题","C:\\Users\\Administrator\\Desktop\\1.png,C:\\Users\\Administrator\\Desktop\\settings.xml",PropertiesUtil.RECEIVER_MAIL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
