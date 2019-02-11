package com.yudainxx.springBootDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixTestController {

    @RequestMapping(value = "/testHystrix")
//    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
    public String hello() throws InterruptedException {
        Thread.sleep(3000);
        return "Welcome Hystrix";
    }
    private String fallback_hello() {
        return "Request fails. It takes long time to response";
    }
}
