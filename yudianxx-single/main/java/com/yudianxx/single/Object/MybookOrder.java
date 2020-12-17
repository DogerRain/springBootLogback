package com.yudianxx.single.Object;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huangyongwen
 * @date 2020/12/17
 * @Description
 */
@Builder
@Data
@TableName("t_book_order")
@AllArgsConstructor
@NoArgsConstructor
public class MybookOrder {
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
