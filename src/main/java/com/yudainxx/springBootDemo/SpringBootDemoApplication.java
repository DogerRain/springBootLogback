package com.yudainxx.springBootDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//Spring Boot Application的入口点是包含@SpringBootApplication注释的类。
//		该类应具有运行Spring Boot应用程序的主要方法。 @SpringBootApplication注释包括自动配置，
//		组件扫描和Spring Boot配置。如果将@SpringBootApplication批注添加到类中，则无需添加@EnableAutoConfiguration，
//@ComponentScan和@SpringBootConfiguration批注。@SpringBootApplication注释包括所有其他注释。
@SpringBootApplication
@EnableScheduling
@RestController
@EnableEurekaClient
@EnableSwagger2

public class SpringBootDemoApplication implements  CommandLineRunner  {
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
		System.out.println("springboot服务正在启动......");
	}

}

