package com.yudianxx.springBootDemo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Value("${spring.application.name:test}")
    //取application.properties 属性 spring.application.name 的值,找不到的话默认值test
    private String name;

    @RequestMapping("/hello")
    public String index() {
        System.out.print("123");
        return "Hello World";
    }

    @RequestMapping("/")
    public String index1() {
        logger.info("this is a info message");
        logger.warn("this is a warn message");
        logger.error("this is a error message");
        return name;
    }
}
