package com.yudianxx.springBootDemo.other;

import com.yudianxx.springBootDemo.annotation.ConditionalOnSystem;
import com.yudianxx.springBootDemo.configuration.SayHelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    @ConditionalOnSystem(system = "linux")
    SayHelloWorld sayHelloWorld() {

        System.out.println("---------------》加载sayhelloworld");

        return new SayHelloWorld();
    }

}
