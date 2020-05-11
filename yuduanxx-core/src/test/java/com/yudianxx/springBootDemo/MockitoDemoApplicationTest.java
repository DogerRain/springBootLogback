package com.yudianxx.springBootDemo;

import com.yudianxx.springBootDemo.service.mockitodemo.OrderService;
import com.yudianxx.springBootDemo.service.mockitodemo.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class MockitoDemoApplicationTest {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
        Mockito.when(productService.getProductName()).thenReturn("Mock Product Name");
        String testName = orderService.getProductName();
        Assert.assertEquals("Mock Product Name", testName);
    }
}
