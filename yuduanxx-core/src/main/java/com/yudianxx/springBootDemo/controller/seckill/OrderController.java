package com.yudianxx.springBootDemo.controller.seckill;

import com.yudianxx.springBootDemo.model.responseVo.RetResponse;
import com.yudianxx.springBootDemo.model.responseVo.RetResult;
import com.yudianxx.springBootDemo.service.seckkill.BookOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author HaC
 * @date 2020/10/16
 * @Description
 */
@RestController
@Slf4j
@RequestMapping("Order/")
public class OrderController {

    @Autowired
//    @Qualifier("bookOrderService")
            BookOrderService bookOrderService;

    @RequestMapping("/seckill/{bookId}")
    public RetResult seckill(@PathVariable @Valid Long bookId) {
        //用户id，这里的用户id应该由前端传入，这里使用 随机数表示
//        log.info("请求进入");
        Long userId = (long) (Math.random() * 1000);
        String result = bookOrderService.seckill(bookId, userId);
        return RetResponse.makeOKRsp(result);
    }
}
