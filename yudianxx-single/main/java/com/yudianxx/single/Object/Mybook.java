package com.yudianxx.single.Object;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("t_book")
@AllArgsConstructor
@NoArgsConstructor
public class Mybook {
    @TableId(value = "book_id", type = IdType.AUTO)
    private long bookId;
    private String name;
    private int count;
}
