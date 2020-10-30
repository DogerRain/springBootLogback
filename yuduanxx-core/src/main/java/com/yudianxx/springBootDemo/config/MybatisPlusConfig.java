package com.yudianxx.springBootDemo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * mybatis-plus 工具配置类
 */
@Configuration
@MapperScan(value = "com.yudianxx.mapper.**")
public class MybatisPlusConfig {

/*
    @Autowired(required = false)
    private Interceptor[] interceptors;
    @Autowired
    private MybatisPlusProperties properties;
*/

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor interceptor = new PaginationInterceptor();
        interceptor.setDialectType(DbType.MYSQL.getDb());
        return interceptor;
    }

    /**
     * 性能分析拦截器，不建议生产使用
     * 打印 sql
     */
//    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //格式化sql语句
        Properties properties = new Properties();
        //true代表打印
        properties.setProperty("format", "true");
        performanceInterceptor.setProperties(properties);
        return performanceInterceptor;
    }

  /*  @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ResourceLoader resourceLoader) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        //*注册Map 下划线转驼峰*
        configuration.setObjectWrapperFactory(new MybatisMapWrapperFactory());
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setPlugins(interceptors);
        // 配置实体类路径、mapperxml路径、类处理路径、数据库枚举路径
        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
            sqlSessionFactory.setTypeHandlersPackage(this.properties.getTypeAliasesPackage());
        }
        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
            sqlSessionFactory.setMapperLocations(this.properties.resolveMapperLocations());
        }
        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
            sqlSessionFactory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
//        sqlSessionFactory.setTypeEnumsPackage();
        sqlSessionFactory.setGlobalConfig(properties.getGlobalConfig());
        return sqlSessionFactory.getObject();
    }*/


}
