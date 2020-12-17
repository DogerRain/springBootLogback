package com.yudianxx.springBootDemo.transation.JDBC事务;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author huangyongwen
 * @date 2020/4/8
 * @Description
 */
//@Component
//@PropertySource(value = "dbinfo.properties") //报找不到这个文件不知道为什么
// 报错 java.lang.IllegalStateException: Failed to load ApplicationContext 可能Test不能获取原生的ApplicationContext容器
@Data
public class SqlHelperTest {

    //连接数据库参数
    @Value("${url}")
    private String url  ;
    @Value("${username}")
    private String username  ;
    @Value("${driver}")
    private String driver  ;
    @Value("${password}")
    private String password  ;




}
