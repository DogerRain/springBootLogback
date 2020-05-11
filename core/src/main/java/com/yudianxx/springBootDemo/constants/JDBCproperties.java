package com.yudianxx.springBootDemo.constants;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author huangyongwen
 * @date 2020/4/8
 * @Description
 */
@Data
@Component
@Slf4j
@PropertySource(value = "dbinfo.properties")
public class JDBCproperties {
    //连接数据库参数
    @Value("${url}")
    public String url;
    @Value("${username}")
    public String username;
    @Value("${driver}")
    public String driver;
    @Value("${password}")
    public String password;

}
