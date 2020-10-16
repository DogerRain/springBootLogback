package com.yudianxx.springBootDemo.service.seckkill;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yudianxx.springBootDemo.mapper.seckill.BookMapper;
import com.yudianxx.springBootDemo.mapper.seckill.OrderMapper;
import com.yudianxx.springBootDemo.model.seckill.Book;
import com.yudianxx.springBootDemo.model.seckill.Order;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author huangyongwen
 * @date 2020/10/16
 * @Description
 */
@Slf4j
@Service
//@Service(value = "bookOrderService")
public class BookOrderService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    RedissonClient redissonClient;

    public String seckill(Long bookId, Long userId) {


        final String lockKey = bookId + "-" + userId + "-RedissonLock";

        RLock rLock = redissonClient.getLock(lockKey);

        try {

            Boolean flag = rLock.tryLock(10, 10, TimeUnit.SECONDS);

            if (!flag) {
                //1、判断这个用户id 是否已经秒杀过
                List<Order> list = orderMapper.selectList(new QueryWrapper<Order>().lambda().eq(Order::getUserId, userId).eq(Order::getStatus, 1).eq(Order::getBookId, bookId));
                if (list.size() >= 1) {
                    log.info("你已经抢过了");

                    return "一人只能抢一次";
                }

                //2、查库存
                Book book = bookMapper.selectOne(new QueryWrapper<Book>().lambda().eq(Book::getBookId, bookId));
                if (book != null && book.getCount() > 0) {
                    //生成订单
                    //订单号
                    String orderId = UUID.randomUUID().toString();
                    //数量，默认 1
                    int count = 1;

                    Order newOrder = Order.builder().
                            orderId(orderId).
                            status(1).
                            bookId(bookId).
                            userId(userId).
                            count(count).
                            billTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).build();

                    orderMapper.insert(newOrder);

                    //更新库存
                    Book newBook = Book.builder().count(book.getCount() - 1).build();
                    bookMapper.update(newBook, new QueryWrapper<Book>().lambda().eq(Book::getBookId, bookId));
                    log.info("userId：{} 秒杀成功", userId);
                    return "秒杀成功" + "";
                }
            } else {
                return "你已经抢过了";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
        }
        return "很遗憾，没货了...";
    }


    public static void main(String[] args) {
//        Jedis jedis = new Jedis("81.71.16.134", 6379);
//        jedis.auth("redis");
//        try {
//            System.out.println(jedis.ping());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
        Long userId = (long) (Math.random() * 1000);
        System.out.println(userId);
    }

}
