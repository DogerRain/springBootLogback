package com.yudianxx.springBootDemo.controller;

import com.yudianxx.springBootDemo.pojo.User;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class CustomerController {
//    private static final Logger LOG = Logger.getLogger(CustomerController.class.getName());
    Logger logger = getLogger(Object.class);
    @RequestMapping("/customers")
    public  String  customersController (){
//        LOG.log(Level.INFO, "Index API is calling");
        String test = "test";
        User user =new User();
        user.setAge(24);
        logger.info("cnm{}",test);
        return "Welcome Sleuth!";    }
}