package com.yudianxx.springBootDemo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("cg_user")
public class User {
    private int id;

    private String userName;

    private String password;

    private int age;


}