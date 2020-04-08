package com.yudianxx.springBootDemo.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {
    private static Properties propetties = new Properties();

    public static void readProperties(String fileName) {
        try {
            InputStream in = PropertiesUtil.class.getResourceAsStream("/" + fileName);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            propetties.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setPropettiesFile(String fileName) {
        PropertiesUtil.readProperties(fileName);
    }

    public static String getProperty(String key) {
        return propetties.getProperty(key);
    }

    public static String MAIL_USERNAME_163 = "";
    public static String MAIL_PASSWORD_163 = "";
    public static String RECEIVER_MAIL = "";

    static {

        MAIL_USERNAME_163 = PropertiesUtil.getProperty("mail_username_163");
        MAIL_PASSWORD_163 = PropertiesUtil.getProperty("mail_password_163");
        RECEIVER_MAIL = PropertiesUtil.getProperty("receiver_mail");
    }

}
