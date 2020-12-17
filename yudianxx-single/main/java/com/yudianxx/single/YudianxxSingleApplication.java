package com.yudianxx.single;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.yudianxx.single"})
@Slf4j
public class YudianxxSingleApplication {

    public static void main(String[] args) {
        SpringApplication.run(YudianxxSingleApplication.class, args);
    }


}
