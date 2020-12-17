package com.yudianxx.springBootDemo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Spring Boot Application的入口点是包含@SpringBootApplication注释的类。
//		该类应具有运行Spring Boot应用程序的主要方法。 @SpringBootApplication注释包括自动配置，
//		组件扫描和Spring Boot配置。如果将@SpringBootApplication批注添加到类中，则无需添加@EnableAutoConfiguration，
//@ComponentScan和@SpringBootConfiguration批注。@SpringBootApplication注释包括所有其他注释。
@SpringBootApplication
//扫描@Scheduled，使用定时任务
@EnableScheduling
@RestController
//@EnableEurekaClient
@EnableSwagger2
//使用Hystrix隔离服务
@EnableHystrix
@EnableAsync //开启异步加载没空 即扫描 @Async
@MapperScan("com.yudianxx.springBootDemo.mapper")
//@EnableAutoConfiguration(exclude = {
//		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
//})
//@ImportResource(locations = {"classpath:/mybatis/spring-mybatis-plus.xml"})
@Slf4j
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringBootDemoApplication implements CommandLineRunner {
    //public class SpringBootDemoApplication extends   SpringBootServletInitializer {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SpringBootDemoApplication.class);
//	}

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    //	spring启动
    @Override
    public void run(String... arg0) throws Exception {
        log.info("springboot服务已启动......");
    }
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any())// 对所有api进行监控
                .apis(RequestHandlerSelectors.basePackage("com.yudianxx.springBootDemo.controller"))
                .build();
    }

    //@Bean 的话一定是一个对象，不能是一个void
    @Bean(name = "methods")
    public String method1(){
        System.out.println("1111111111111111111111111111111");
        return null;
    }
}

