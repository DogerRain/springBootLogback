package com.yudianxx.springBootDemo.transation;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    TransactionTestService transactionTestService;
    @org.junit.Test
    public void test() {
        transactionTestService.testTransactional();
    }

}
