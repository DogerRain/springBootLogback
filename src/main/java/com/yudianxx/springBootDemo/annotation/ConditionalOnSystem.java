package com.yudianxx.springBootDemo.annotation;


import com.yudianxx.springBootDemo.configuration.OnSystemCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
//当调用system的时候，就会去加载这个OnSystemCondition.class这个类，假如不止一个system参数呢，估计应该也是会加载这个类
@Conditional({OnSystemCondition.class})
public @interface ConditionalOnSystem {

    String system();


}
