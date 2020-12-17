package com.yudianxx.springBootDemo.transation.for循环的事务;

import com.yudianxx.springBootDemo.model.seckill.Book;
import com.yudianxx.springBootDemo.model.seckill.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
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
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTestFor {

    @Autowired
    BookorderServices bookorderServices;

    @org.junit.Test
    public void test() {
        tran();
    }

    @Transactional(rollbackForClassName = {"Exception", "RuntimeException"}, propagation = Propagation.REQUIRED)
    public void tran() {
        Book book1 = Book.builder().name("1").build();
        Book book2 = Book.builder().name("2").build();
        Book book3 = Book.builder().name("3").build();
        List<Book> list = new ArrayList<Book>() {{
            add(book1);
            add(book2);
            add(book3);
        }};

        for (Book book : list) {
            try {
                Book returnBook = bookorderServices.insertBook(book);
                if (book.getName().equals("2")){
                    throw new RuntimeException("book2报错");
                }
                String orderId = UUID.randomUUID().toString();
                //数量，默认 1
                int count = 1;

                Order newOrder = Order.builder().
                        bookOrderId(orderId).
                        status(1).
                        bookId(returnBook.getBookId()).
                        count(count).
                        billTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).build();
                bookorderServices.inserBookOrder(newOrder);
            }catch (Exception e){
                throw e;
            }
        }


    }


}



