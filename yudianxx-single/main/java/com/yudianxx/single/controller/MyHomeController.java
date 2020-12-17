package com.yudianxx.single.controller;

import com.yudianxx.single.service.TransactionTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//注意：@controller不是@RestController，使用@RestController会返回“index”字符串
@RestController
@RequestMapping("/")
@Slf4j
public class MyHomeController {

    @Autowired
    TransactionTestService transactionTestService;

    @RequestMapping("/test")
    public String test() {
        log.info("进入事务测试");
        transactionTestService.tran();
        return "yes";
    }
}
