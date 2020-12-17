package com.yudianxx.springBootDemo.transation.for循环的事务;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author huangyongwen
 * @date 2020/12/17
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class TransactionTestFor {

    @Autowired
    BookorderServices bookorderServices;


    @org.junit.Test
    public void test() {
        bookorderServices.tran();
    }




}



