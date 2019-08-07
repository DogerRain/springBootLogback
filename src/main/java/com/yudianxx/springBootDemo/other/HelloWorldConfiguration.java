package com.yudianxx.springBootDemo.other;

import com.yudianxx.springBootDemo.annotation.ConditionalOnSystem;
import com.yudianxx.springBootDemo.configuration.SayHelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    //match 返回true才会进入这个方法
    @ConditionalOnSystem(system = "linux",value = "request/a")
    SayHelloWorld SayHelloWorld() {

        System.out.println("---------------》加载sayhelloworld");

        return new SayHelloWorld();
    }

    SayHelloWorld SayHelloWorld1() {

        System.out.println("---------------》加载sayhelloworld1111111111");

        return new SayHelloWorld();
    }

}
