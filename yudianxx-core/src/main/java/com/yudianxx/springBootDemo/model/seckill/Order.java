package com.yudianxx.springBootDemo.model.seckill;

/**
 * @author 公众号：HelloCoder，每天分享Java技术和面试题
 * @date 2020/10/16
 * @Description
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@TableName("t_book_order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    @TableField(value = "book_order_id")
    private String bookOrderId;
    private long bookId;
    private int status;
    private long userId;
    private int count;
    private String billTime;
}