package com.yudianxx.springBootDemo.service.impl;

import com.yudianxx.springBootDemo.domain.Customer;
import com.yudianxx.springBootDemo.mapper.image.ModelMapper;
import com.yudianxx.springBootDemo.model.image.Model;
import com.yudianxx.springBootDemo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer queryCustomer() {
        return null;
    }

    @Autowired
    CustomerServiceImpl selfMeiztuService;

    @Autowired
    ModelMapper modelMapper;

    /**
     * 事务测试
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Model testTransactional() throws Exception {
        Model model = Model.builder().id(100l).name("事务测试").build();
//        try {
//            a(model);  //内部类调用，事务不起作用，加入a()报错了，插入仍然有效
//            b(model);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            selfMeiztuService.a(model);
            selfMeiztuService.b(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            /**
             * 下面这两个报错了selfMeiztuService.a(model);selfMeiztuService.b(model)并不会回滚
             * ;不知道为什么，可能是没有事务
             */
            //  throw new RuntimeException();
            //  int i=1/0;
            selfMeiztuService.c(model);  //这个就能回滚
        } catch (Exception e) {
            //         throw e; //把错误抛出来，@Transactional才能发现
        }
        return model;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void a(Model model) {
        log.info("进入A方法");
        model.setName("事务测试a");
        modelMapper.insert(model);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void b(Model model) {
        log.info("进入B方法");
        model.setName("事务测试b");
        modelMapper.insert(model);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void c(Model model) {
        log.info("进入c方法");
        int i = 1 / 0;
    }

}
