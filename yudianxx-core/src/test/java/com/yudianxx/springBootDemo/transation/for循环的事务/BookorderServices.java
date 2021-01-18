package com.yudianxx.springBootDemo.transation.for循环的事务;

import com.yudianxx.springBootDemo.mapper.seckill.BookMapper;
import com.yudianxx.springBootDemo.mapper.seckill.OrderMapper;
import com.yudianxx.springBootDemo.model.seckill.Book;
import com.yudianxx.springBootDemo.model.seckill.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
@Service("bookorderServices")
public class BookorderServices {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    BookorderServices bookorderServices;

    @Transactional(propagation = Propagation.REQUIRED)
    public Book insertBook(Book book) {
        bookMapper.insert(book);
        return book;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void inserBookOrder(Order bookOrder) {
        orderMapper.insert(bookOrder);
    }

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
            bookorderServices.insert(book);
        }


    }

    @Transactional(rollbackForClassName = {"Exception", "RuntimeException"}, propagation = Propagation.REQUIRED)
    public void insert(Book book) {
        try {
            Book returnBook = bookorderServices.insertBook(book);

            if (book.getName().equals("2")) {
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
                    billTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                    .build();
            bookorderServices.inserBookOrder(newOrder);
        } catch (Exception e) {

            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }
    }

}




class MyFirstJavaDemo {
    public static void main(String[] args) {  //语法
        String name = "I am HaC";  //先定义name
        System.out.println("HelloWorld," + name); //流程控制，输出，使用name
    }
}