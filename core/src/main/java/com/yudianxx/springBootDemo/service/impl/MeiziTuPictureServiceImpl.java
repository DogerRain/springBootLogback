package com.yudianxx.springBootDemo.service.impl;


import com.yudianxx.springBootDemo.mapper.image.ImageCategoryMapper;
import com.yudianxx.springBootDemo.model.image.Category;
import com.yudianxx.springBootDemo.service.MeiztuPictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MeiziTuPictureServiceImpl implements MeiztuPictureService {

    @Autowired
    MeiztuPictureService selfMeiztuService;

    @Autowired
    ImageCategoryMapper imageCategoryMapper;

    /**
     * 事务测试
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void testTransactional() {
        Category category = Category.builder().id(100l).name("事务测试").build();
//        try {
//            a(model);  //内部类调用，事务不起作用，加入a()报错了，插入仍然有效
//            b(model);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try{
            selfMeiztuService.a(category);
            selfMeiztuService.b(category);
//        throw new RuntimeException();
            int k =1/0;
        }catch (Exception e){

        }
      /*  try {
            selfMeiztuService.a(category);
            selfMeiztuService.b(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            *//**
             * 下面这两个报错了
             * selfMeiztuService.a(model);selfMeiztuService.b(model)并不会回滚
             * ;不知道为什么，可能是没有事务 cath可能要加 TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
             *//*
            //  throw new RuntimeException();
              int i=1/0;
//            selfMeiztuService.c(category);  //这个就能回滚
        } catch (Exception e) {
                     throw e; //把错误抛出来，@Transactional才能发现
//            log.error("e",e);
        }*/
    }

    //    @Transactional(propagation = Propagation.REQUIRES_NEW)
// 会单独起一个事务，成功了则插入，不受其他事务影响
    @Transactional(propagation = Propagation.REQUIRED)
    public void a(Category category) {
        log.info("进入A方法");
        category.setName("事务测试a");
        imageCategoryMapper.insert(category);
    }

    //    @Transactional(propagation = Propagation.REQUIRES_NEW) //B成功插入，新开的事务和原来的事务没关系
    @Transactional(propagation = Propagation.REQUIRED)
    public void b(Category category) {
        log.info("进入B方法");
        category.setName("事务测试b");
        imageCategoryMapper.insert(category);
    }

//        @Transactional(propagation = Propagation.REQUIRED)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void c(Category category) {
        log.info("进入c方法");
        int i = 1 / 0;


//        try {
//            int j = 1 / 0;
//        } catch (Exception e) {
//            throw e;
//        }
    }
}