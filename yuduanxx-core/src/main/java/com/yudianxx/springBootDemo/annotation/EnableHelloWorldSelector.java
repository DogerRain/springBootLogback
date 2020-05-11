package com.yudianxx.springBootDemo.annotation;

import com.yudianxx.springBootDemo.configuration.HelloWorldConfigurationSeletor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({HelloWorldConfigurationSeletor.class})
public @interface EnableHelloWorldSelector {

    String model() default "first";



}
