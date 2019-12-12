package com.yudianxx.springBootDemo.annotation;

import com.yudianxx.springBootDemo.annotation.MyAnnotation;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author huangyongwen
 * @date 2019/12/12
 * @Description
 */
@Aspect
@Component
public class AnnotationAspect {



    @Around(value = "@annotation(around)")
    public void processAuthority(ProceedingJoinPoint point, MyAnnotation around) throws Throwable {
        System.out.println("ANNOTATION welcome");
        System.out.println("ANNOTATION 调用方法：" + around.methodName());
        System.out.println("ANNOTATION 调用类：" + point.getSignature().getDeclaringTypeName());
        System.out.println("ANNOTATION 调用类名" + point.getSignature().getDeclaringType().getSimpleName());
        point.proceed(); //调用目标方法
        System.out.println("ANNOTATION login success");
    }
}
