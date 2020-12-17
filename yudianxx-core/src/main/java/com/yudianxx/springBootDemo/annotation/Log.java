package com.yudianxx.springBootDemo.annotation;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * @see indi.zhuyst.skyblog.entity.SysLogDO#type
     * @return 操作类型
     */
    SysLogTypeEnum type() default SysLogTypeEnum.UNDEFINED;

    /**
     * @see indi.zhuyst.skyblog.entity.SysLogDO#resource
     * @return 资源
     */
    String resource() default "";
}
