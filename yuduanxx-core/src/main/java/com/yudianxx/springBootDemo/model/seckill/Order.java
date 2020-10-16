package com.yudianxx.springBootDemo.model.seckill;

/**
 * @author huangyongwen
 * @date 2020/10/16
 * @Description
 */
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Builder
@Data
@TableName("t_book_order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String orderId;
    private long bookId;
    private int status;
    private long userId;
    private int count;
    private String billTime;
}