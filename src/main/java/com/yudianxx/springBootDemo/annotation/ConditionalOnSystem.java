package com.yudianxx.springBootDemo.annotation;


import com.yudianxx.springBootDemo.configuration.OnSystemCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional({OnSystemCondition.class})
public @interface ConditionalOnSystem {

    String system();

    Boolean flag=false;

}
