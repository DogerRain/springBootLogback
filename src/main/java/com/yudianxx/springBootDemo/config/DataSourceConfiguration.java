package com.yudianxx.springBootDemo.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zita
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(MysqlConfigProperties.class)
public class DataSourceConfiguration {

    @Autowired
    private MysqlConfigProperties properties;

    @Bean
    public DataSource druidDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setDbType("mysql");
        datasource.setUrl(properties.getUrl());
        datasource.setUsername(properties.getUsername());
        datasource.setPassword(properties.getPassword());
        datasource.setDriverClassName(properties.getDriverClassName());
        datasource.setInitialSize(properties.getInitialSize());
        datasource.setMinIdle(properties.getMinIdle());
        datasource.setMaxActive(properties.getMaxActive());
        datasource.setMaxWait(properties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(properties.getValidationQuery());
        datasource.setTestWhileIdle(properties.isTestWhileIdle());
        datasource.setTestOnBorrow(properties.isTestOnBorrow());
        datasource.setTestOnReturn(properties.isTestOnReturn());
        datasource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
        List<Filter> filterList = new ArrayList<Filter>();
        filterList.add(wallFilter());
        datasource.setProxyFilters(filterList);
        try {
            datasource.setFilters(properties.getFilters());
        } catch (SQLException e) {
            log.error("druid configuration initialization filter", e);
        }
        return datasource;
    }

    @Bean
    public WallFilter wallFilter() {
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig());
        return wallFilter;
    }

    @Bean
    public WallConfig wallConfig() {
        WallConfig config = new WallConfig();
        //允许一次执行多条语句
        config.setMultiStatementAllow(true);
        //允许非基本语句的其他语句
        config.setNoneBaseStatementAllow(true);
        return config;
    }

//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        ServletRegistrationBean reg = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        reg.addInitParameter("loginUsername", "admin");
//        reg.addInitParameter("loginPassword", "admin");
//        reg.addInitParameter("logSlowSql", properties.getLogSlowSql());
//        return reg;
//    }

//    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }
}
