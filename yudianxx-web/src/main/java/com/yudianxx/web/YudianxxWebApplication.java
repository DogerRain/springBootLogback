package com.yudianxx.web;

import com.yudianxx.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class YudianxxWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(YudianxxWebApplication.class, args);
        log.info("输出：{}",Constants.HTTPS);
    }

//    @Bean
//    @ConditionalOnMissingBean(InternalResourceViewResolver.class)
//    public InternalResourceViewResolver defaultViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
}
