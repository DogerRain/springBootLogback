package com.yudianxx.springBootDemo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//注意：@controller不是@RestController，使用@RestController会返回“index”字符串
@Controller
@Slf4j
public class HomeController {
    @RequestMapping("/test")
//    public Object test(@RequestBody User user) {
    public String  test() {
        ModelAndView mode = new ModelAndView();
        mode.addObject("name", "zhangsan");
        log.info("进来了");
        return "hello";
    }

}
