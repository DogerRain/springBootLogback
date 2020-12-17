package com.yudianxx.springBootDemo.transation;

import com.yudianxx.springBootDemo.mapper.image.ImageCategoryMapper;
import com.yudianxx.springBootDemo.model.image.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


@Service
@Slf4j
public class TransactionTestServiceImpl implements TransactionTestService {


    @Autowired
    TransactionTestServiceImpl transactionTestService;

    @Autowired
    ImageCategoryMapper imageCategoryMapper;

    /**
     * 事务测试
     *
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void testTransactional() {
        Category category = Category.builder().name("事务测试").build();
/*//       情况一 1.
        try {
            a(category);  //内部类调用，事务不起作用，加入a()报错了，插入仍然有效，相当于普通调用
            b(category);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

/*
//        情况二 2.
        transactionTestService.a(category);
        transactionTestService.b(category);
//        throw new RuntimeException();   //没有try catch ，父、子同一事务，父报错，全回滚
*/

/*//        情况二 3.
        try{
            transactionTestService.a(category);
            transactionTestService.b(category);
            throw new RuntimeException();  //父、子同一事务,子方法没有抛异常,父虽然抛了异常但是被catch到，等于没抛出过,所以都不会回滚
        }catch (Exception e){

        }*/


/*//          情况二 4.
        try {
            transactionTestService.a(category);
            transactionTestService.b(category);
            throw new RuntimeException();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //强制回滚,假如子是REQUIRES_NEW，则子不回滚
        }*/

/*//          情况二 4.
        try {
            transactionTestService.a(category);
            transactionTestService.b(category);
            throw new RuntimeException();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //强制回滚,假如子是REQUIRES_NEW，则子不回滚
        }*/

//          情况二5.
        try {
            transactionTestService.a(category);
            transactionTestService.b(category);
//            transactionTestService.c(category);  //不回滚
//           transactionTestService.d(category); //回滚
//           transactionTestService.e(category); //不回滚 e是另外的事务
//           transactionTestService.f(category); //a、b不回滚，f回滚
            transactionTestService.g(category); //a、b、g都不回滚
        } catch (Exception e) {

        }

    }

    //    @Transactional(propagation = Propagation.REQUIRES_NEW)
// 会单独起一个事务，成功了则插入，不受其他事务影响
    @Transactional(propagation = Propagation.REQUIRED)
    public void a(Category category) {
        log.info("进入A方法");
        category.setName("事务测试a");
        imageCategoryMapper.insert(category);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void b(Category category) {
        log.info("进入B方法");
        category.setName("事务测试b");
        imageCategoryMapper.insert(category);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void c(Category category) {
        log.info("进入c方法");
        try {
            int j = 1 / 0;
        } catch (Exception e) {
//            throw e;  //如果是把错误抛出来了，上层捕获了就会回滚事务的，如果没有throw，这个方法自己处理了异常就不会抛,相当于没抛异常正常执行
            //简单的说，throw e 了相当于没有加try catch
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void d(Category category) {
        log.info("进入d方法");
        int j = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void e(Category category) {
        log.info("进入e方法");
        int j = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void f(Category category) {
        log.info("进入f方法");
        category.setName("事务测试f");
        imageCategoryMapper.insert(category);
        int j = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void g(Category category) {
        log.info("进入g方法");
        category.setName("事务测试g");
        imageCategoryMapper.insert(category);
        try {
            int j = 1 / 0;
        } catch (Exception e) {

        }
    }




}
