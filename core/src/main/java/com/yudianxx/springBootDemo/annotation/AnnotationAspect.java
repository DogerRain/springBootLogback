package com.yudianxx.springBootDemo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author huangyongwen
 * @date 2019/12/12
 * @Description
 */
@Aspect
@Component
@Slf4j
public class AnnotationAspect {
    @Around(value = "@annotation(around)")
    public Object processAuthority(ProceedingJoinPoint point, MyAnnotation around) throws Throwable {
//        System.out.println("ANNOTATION welcome");
//        System.out.println("ANNOTATION 调用方法：" + around.methodName());
//        System.out.println("ANNOTATION 调用类：" + point.getSignature().getDeclaringTypeName());
//        System.out.println("ANNOTATION 调用类名" + point.getSignature().getDeclaringType().getSimpleName());
//        point.proceed(); //调用目标方法
//        System.out.println("ANNOTATION login success");
        log.info("——————————————————————start————————————————————————");
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method targetMethod = methodSignature.getMethod();
        MyAnnotation myAnnotation = targetMethod.getAnnotation(MyAnnotation.class);
        log.info("当前执行的方法为：{},操作：{}", myAnnotation.methodName(), myAnnotation.description());
        long startTime = System.currentTimeMillis();
        log.info("执行前，当前时间：{}", startTime);
        Object result = point.proceed();
        long endTime = System.currentTimeMillis();
        log.info("执行后，当前时间：{}", endTime);
        log.info("耗时{},{} endTime - startTime={}", endTime, startTime, endTime - startTime);
        log.info("——————————————————————end————————————————————————");
        return result;
    }
}
