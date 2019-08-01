package com.yudianxx.springBootDemo.annotation;

import com.yudianxx.springBootDemo.other.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({HelloWorldConfiguration.class})
public @interface EnableHelloWorld {
}
