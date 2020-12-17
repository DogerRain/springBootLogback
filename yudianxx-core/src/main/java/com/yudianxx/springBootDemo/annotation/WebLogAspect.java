package com.yudianxx.springBootDemo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j

@Aspect
@Component
public class WebLogAspect {

    /*
     *execution(com.yudianxx.springBootDemo.controller.*.*(..))) 表示包中所有的类的所有方法切面
     *execution(com.yudianxx.springBootDemo.controller..*.*(..)) 表示及其子包中所有的类的所有方法切面 (不生效)
     *execution(com.yudianxx.springBootDemo.controller.StudentController.*(..)) 表示只针对StudentController类切面
     *
     * */
    @Pointcut(value = "execution(* com.yudianxx.springBootDemo.controller.*.*(..))")
    public void webControllerLog() {
    }

    /**
     * 环绕日志 记录controller调用的日志.
     *
     */
//    @Around(value = "webControllerLog()")
    public void controllerBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("\n");
        log.info("-------------------Request Content-------------------");
        log.info("[Request IP] : {}", request.getRemoteAddr());
        log.info("[Request URL] : {} ", request.getRequestURL());
        log.info("[Request Method] : {}", request.getMethod());
        log.info("[Class Method] : {}", joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        if (args == null) {
            log.info("[Args is NULL] : {}", "NULL");
        } else {
            log.info("[Class Method Args] : " + Arrays.toString(args));
        }
        log.info("-------------------Request Content-------------------");
        log.info("\n");
    }

}
