package com.yudianxx.springBootDemo.transation.JDBC事务;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author huangyongwen
 * @date 2020/4/8
 * @Description 原生JDBC使用事务
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class JDBC {

    @Autowired
    SqlHelperTest sqlHelperTest;

    @Test
    public void test() {
        new JDBC().JDBCUseTransation();
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
    public Connection getConnection() {
        //定义需要的变量
        Connection ct = null;
        try {
            log.info("mysql url:{}", new SqlHelperTest().getUrl());
            ct = DriverManager.getConnection(sqlHelperTest.getUrl(), sqlHelperTest.getUsername(), sqlHelperTest.getPassword());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ct;
    }

}

