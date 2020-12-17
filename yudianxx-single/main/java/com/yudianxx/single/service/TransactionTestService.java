package com.yudianxx.single.service;

import com.yudianxx.single.Object.Mybook;
import com.yudianxx.single.Object.MybookOrder;
import com.yudianxx.single.mapper.MyBookMapper;
import com.yudianxx.single.mapper.MyBookOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author huangyongwen
 * @date 2020/12/17
 * @Description
 */
@Service
public class TransactionTestService {

    @Autowired
    TransactionTestService transactionTestService;


    @Transactional(rollbackForClassName = {"Exception", "RuntimeException"}, propagation = Propagation.REQUIRED)
    public void tran() {
        Mybook book1 = Mybook.builder().name("1").build();
        Mybook book2 = Mybook.builder().name("2").build();
        Mybook book3 = Mybook.builder().name("3").build();
        List<Mybook> list = new ArrayList<Mybook>() {{
            add(book1);
            add(book2);
            add(book3);
        }};

        for (Mybook book : list) {
            try {
                Mybook returnMybook = transactionTestService.insertBook(book);
                if (book.getName().equals("2")) {
                    throw new RuntimeException("book2报错");
                }
                String orderId = UUID.randomUUID().toString();
                //数量，默认 1
                int count = 1;

                MybookOrder newOrder = MybookOrder.builder().
                        bookOrderId(orderId).
                        status(1).
                        bookId(returnMybook.getBookId()).
                        count(count).
                        billTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).build();
                transactionTestService.inserBookOrder(newOrder);
            } catch (Exception e) {
                throw e;
            }
        }


    }

    @Autowired
    MyBookMapper bookMapper;

    @Autowired
    MyBookOrderMapper orderMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public Mybook insertBook(Mybook book){
        bookMapper.insert(book);
        return book;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void inserBookOrder(MybookOrder bookOrder){
        orderMapper.insert(bookOrder);
    }

}
