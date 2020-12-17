package com.yudianxx.single.controller;

import com.yudianxx.single.service.TransactionTestService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

//注意：@controller不是@RestController，使用@RestController会返回“index”字符串
@Controller
@Slf4j
@MapperScan("com.yudianxx.sigle.mapper")
public class MyHomeController {


    @Resource(name = "transactionTestService")
    TransactionTestService transactionTestService;

    @RequestMapping("/test")
//    public Object test(@RequestBody User user) {
    public String test() {
        log.info("进入事务测试");
        transactionTestService.tran();
        return "yes";
    }
}
