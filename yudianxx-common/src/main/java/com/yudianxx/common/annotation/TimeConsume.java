package com.yudianxx.common.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface TimeConsume {
    /**
     * 记录操作
     */
    String methodName() default "";

    String description() default "";
}
