package com.yudianxx.springBootDemo.controller;


import com.alibaba.fastjson.JSONObject;
import com.yudianxx.springBootDemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meizitu")
@Slf4j
public class MeiZiPictureController {
    @RequestMapping("/test")
//    public Object test(@RequestBody User user) {
    public Object test() {
        log.info("小程序接口调入");
        System.out.println("1111111");
        User user1 = User.builder().age(25).userName("黄以太网").password("123").build();
        return JSONObject.toJSON(user1);
    }

}
