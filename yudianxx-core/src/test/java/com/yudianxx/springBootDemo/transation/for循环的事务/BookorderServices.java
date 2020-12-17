package com.yudianxx.springBootDemo.transation.for循环的事务;

import com.yudianxx.springBootDemo.mapper.seckill.BookMapper;
import com.yudianxx.springBootDemo.mapper.seckill.OrderMapper;
import com.yudianxx.springBootDemo.model.seckill.Book;
import com.yudianxx.springBootDemo.model.seckill.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation = Propagation.REQUIRED)
    public Book insertBook(Book book){
        bookMapper.insert(book);
        return book;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void inserBookOrder(Order bookOrder){
        orderMapper.insert(bookOrder);
    }

}
