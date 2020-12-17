package com.yudianxx.springBootDemo.model.image;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Builder
@Data
@TableName("t_images")
public class Image implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String title;
    private String imageLink;
    private String content;
    private String modelId;
    private String collection;
    private String category;
    private String suggestion;
    private String status;
    private String createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date editTime;
}
