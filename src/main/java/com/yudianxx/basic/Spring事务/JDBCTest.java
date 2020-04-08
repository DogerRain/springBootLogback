package com.yudianxx.basic.Spring事务;

import com.yudianxx.springBootDemo.Utils.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author huangyongwen
 * @date 2020/4/8
 * @Description
 */
public class JDBCTest {
    public static void main(String[] args) {
        new JDBCTest().JDBCUseTransation();
    }

    public Boolean JDBCUseTransation() {
        Boolean result = false;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false); //开启事务，禁止自动提交
            preparedStatement = conn.prepareStatement("update t_category t set t.name='测试' where t.id =?");
            preparedStatement.setInt(1, 10);
            result = preparedStatement.executeUpdate() > 0 ? true : false;
            conn.commit(); //提交事务

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    //得到连接
    public Connection getConnection() throws ClassNotFoundException {
        PropertiesUtil.setPropettiesFile("dbinfo.properties");
        String url = PropertiesUtil.getProperty("url");
        String username = PropertiesUtil.getProperty("username");
        String root = PropertiesUtil.getProperty("password");
        String driver = PropertiesUtil.getProperty("driver");
        Class.forName(driver);
        //定义需要的变量
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, root);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return connection;
    }
}
