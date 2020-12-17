package com.yudianxx.springBootDemo.controller;


import com.alibaba.fastjson.JSONObject;
import com.yudianxx.common.result.RetCode;
import com.yudianxx.common.result.RetResponse;
import com.yudianxx.common.result.RetResult;
import com.yudianxx.springBootDemo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/meizitu")
@Slf4j
public class MeiZiPictureController {
    @RequestMapping("/test")
    public Object test(@RequestBody @Validated User user) {
        log.info(user + "");
        log.info("小程序接口调入");
        user = null;
        user.getPassword();
        User user1 = User.builder().age(25).userName("黄以太网").password(null).id(user.getId()).build();
        return JSONObject.toJSON(user1);
    }

    @RequestMapping(value = "/test1")
    public Object test1(@RequestParam(value = "id", required = false) Integer id) {
        System.out.println("id的值" + id);
        User user1 = User.builder().age(25).userName("黄以太网").password("123").id(id).build();
        return JSONObject.toJSON(user1);
    }

    @RequestMapping("/test2")
    public Object test2(User user) {
//    public Object test() {
        System.out.println(user);
        log.info("小程序接口调入");
        System.out.println("1111111");
        User user1 = User.builder().age(25).userName("黄以太网").password("123").id(user.getId()).build();
        return JSONObject.toJSON(user1);
    }


    /**
     * 多个传参也是可以的
     *
     * @param id
     * @param user
     */
    @RequestMapping(value = "/test3/{id}", method = RequestMethod.POST)
    public void test3(@PathVariable @Valid String id, @RequestBody User user, @RequestParam(value = "id", required = false) Integer id1) {
        log.info("user:{}", user);
        log.info("id = {} ", id);
        log.info("id1 = {} ", id1);
    }

//    http://hellocoder.com/Order/seckill/1?userId=557
    @RequestMapping("/seckill/{bookId}")
    public RetResult seckill(@PathVariable @Valid Long bookId, @RequestParam(value = "userId", required = false) Long userId) {
        log.info("userId:{},bookId:{}", userId, bookId);
//        String result = bookOrderService.seckill(bookId, userId);
        return RetResponse.makeOkRspCodeAndMsg(RetCode.APP_USERNAME_EXISTS);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User1 {
    private Integer id;
    private String name;
    private Integer age;
}