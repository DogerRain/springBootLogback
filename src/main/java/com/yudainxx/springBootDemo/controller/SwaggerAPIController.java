package com.yudainxx.springBootDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SwaggerAPIController {
    private static final Logger logger = LoggerFactory.getLogger(SwaggerAPIController.class);
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<String> getProducts() {
        logger.info("进入api的products GET方法");
        List<String> productsList = new ArrayList<>();
        productsList.add("Honey");
        productsList.add("Almond");
        return productsList;
    }
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String createProduct() {
        logger.info("进入api的products POST方法");
        return "Product is saved successfully";
    }
}
