package com.yudianxx.basic.Java8新特性.lambda2;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huangyongwen
 * @date 2020/11/2
 * @Description
 */
@Builder
@Data
class MyUser {
    private long id;

    //姓名
    private String name;

    //年龄
    private int age;

    //工号
    private String jobNumber;

    //性别
    private int gender;

    //入职日期
    private Date entryDate;

    //钱
    private BigDecimal money;
}

public class LambdaTest {
    public static void main(String[] args) {
        List<MyUser> myUserList = new ArrayList<>();
        MyUser u1 = MyUser.builder().age(23).name("小李").jobNumber("9527").money(new BigDecimal("12000")).build();
        MyUser u2 = MyUser.builder().age(24).name("小哈").jobNumber("95272").money(new BigDecimal("13000")).build();
        myUserList.add(u1);
        myUserList.add(u2);


        Map<Integer, List<MyUser>> groupByAge = myUserList.stream().collect(Collectors.groupingBy(MyUser::getAge));


        //再求和
        BigDecimal totalMoney = myUserList.stream().map(MyUser::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(totalMoney);

    }
}
