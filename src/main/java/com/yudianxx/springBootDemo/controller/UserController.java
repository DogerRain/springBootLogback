package com.yudianxx.springBootDemo.controller;

import com.yudianxx.springBootDemo.pojo.User;
import com.yudianxx.springBootDemo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@RestController
public class UserController {
    @Resource
    private UserService userService;
    private static final Logger log = Logger.getLogger(UserController.class.getName());
    @RequestMapping(value="/showUser")
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