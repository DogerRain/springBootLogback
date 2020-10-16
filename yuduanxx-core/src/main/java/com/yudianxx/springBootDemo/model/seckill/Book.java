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
@TableName("t_book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @TableId(value = "book_id", type = IdType.AUTO)
    private long bookId;
    private String name;
    private int count;
}
