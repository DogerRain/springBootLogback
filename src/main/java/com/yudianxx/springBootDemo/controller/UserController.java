package com.yudianxx.springBootDemo.controller;

import com.yudianxx.springBootDemo.model.User;
import com.yudianxx.springBootDemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("NEOC/")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @ApiOperation(value = "散标信息", notes = "入库散标信息（会自动生成产品信息）")
    @RequestMapping(value = "/insert/bidInfo", method = RequestMethod.POST)
    public User getUserById(HttpServletRequest request, @RequestParam Integer userId){
        int userId1 = Integer.parseInt(request.getParameter("userId"));
        log.info("userId1的值为："+userId1);
        int userId2 =userId;
        log.info("userId2的值为："+userId2);
        User user = userService.getUserById(userId1);
        log.info("User："+user);
        return user;
    }

}