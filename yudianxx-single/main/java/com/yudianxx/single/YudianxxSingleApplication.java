package com.yudianxx.single;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.yudianxx.single.mapper"})
@Slf4j
@EnableTransactionManagement
public class YudianxxSingleApplication {

    public static void main(String[] args) {
        SpringApplication.run(YudianxxSingleApplication.class, args);
    }


}
