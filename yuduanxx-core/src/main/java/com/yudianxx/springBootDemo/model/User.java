package com.yudianxx.springBootDemo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@TableName("cg_user")
public class User {
    private int id;

    @NotNull
    @Length(min = 2, max = 10)
    private String userName;

    private String password;

    private int age;


}