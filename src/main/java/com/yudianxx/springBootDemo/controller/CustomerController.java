package com.yudianxx.springBootDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;
@RestController
public class CustomerController {
    private static final Logger LOG = Logger.getLogger(CustomerController.class.getName());
    @RequestMapping("/customers")
    public  String  customersController (){
        LOG.log(Level.INFO, "Index API is calling");
        return "Welcome Sleuth!";    }
}