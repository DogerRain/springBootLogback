package com.yudianxx.springBootDemo.controller;

import com.yudianxx.springBootDemo.annotation.MyAnnotation;
import com.yudianxx.springBootDemo.model.User;
import com.yudianxx.springBootDemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("NEOC/")
@Slf4j
@ConditionalOnClass(RestTemplate.class)
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    ImageController imageController;
//    @Autowired
//    MeiztuPictureService meiztuPictureService;

    @ApiOperation(value = "散标信息", notes = "入库散标信息（会自动生成产品信息）")
    @RequestMapping(value = "/insert/bidInfo", method = RequestMethod.POST)
//    @Log(resource = "123", type = SysLogTypeEnum.UPDATE)
    @MyAnnotation(methodName = "getUserById",description = "进入主接口")
    public User getUserById(@RequestBody User user, HttpServletRequest request) throws InterruptedException {
//        int userId1 = Integer.parseInt(request.getParameter("userId"));
//        log.info("userId1的值为："+userId1);
        int userId2 = user.getId();
//        log.info("userId2的值为：" + userId2);
//        log.info("User：" + user);
        userService.getUserById(userId2);
        return user;
//        Connection connection = DriverManager.getConnection();

    }

//    @LoadBalanced
//    @Autowired(required = false)
    private List<RestTemplate> restTemplates = Collections.emptyList();

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void test(){
//        meiztuPictureService.testTransactional();
    }


}