package com.yudianxx.basic.Java8新特性.lambda;

import lombok.Data;

/**
 * @author huangyongwen
 * @date 2020/9/9
 * @Description
 */
@Data
public class Person {

    String firstName;
    String secondName;


    Person(){
        this("王","铁蛋");
    }

    Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
