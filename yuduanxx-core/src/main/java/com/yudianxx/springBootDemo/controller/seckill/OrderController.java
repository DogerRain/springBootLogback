package com.yudianxx.springBootDemo.controller.seckill;

import com.yudianxx.springBootDemo.model.responseVo.RetResponse;
import com.yudianxx.springBootDemo.model.responseVo.RetResult;
import com.yudianxx.springBootDemo.service.seckkill.BookOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    BookOrderService bookOrderService;


    @RequestMapping("/seckill")
    public RetResult seckill(@RequestParam(value = "bookId") Long bookId, @RequestParam(value = "userId", required = false) Long userId) {
        if (userId == null) {
            //模拟userId，随机生成，这里应该有前端传入
            userId = (long) (Math.random() * 1000);
        }
        String result = bookOrderService.seckill(bookId, userId);
        return RetResponse.makeOKRsp(result);
    }
}
