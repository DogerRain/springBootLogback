package com.yudianxx.springBootDemo.annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
@Order(-100)
@Slf4j
public class SysLogAspect {
    @Autowired
//    private SysLogService sysLogService;

    @Pointcut("@annotation(com.yudianxx.springBootDemo.annotation.Log)")
    public void pointCut() {}

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        this.saveLog(point);
        return result;
    }
    /**
     * 保存系统日志
     * @param point 切面
     */
    private void saveLog(ProceedingJoinPoint point) throws Exception {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        // 设置操作类型以及信息
        Log annotation = method.getAnnotation(Log.class);
//        log.setType(annotation.type().getName());
//        log.setResource(annotation.resource());
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("\n");
        log.info("-------------------Request Content-------------------");
        log.info("[Request IP] : {}", request.getRemoteAddr());
        log.info("[Request URL] : {} ", request.getRequestURL());
        log.info("[Request Method] : {}", request.getMethod());
        log.info("[Class Method] : {}", point.getSignature());
        Object[] args = point.getArgs();
        if (args == null) {
            log.info("[Args is NULL] : {}", "NULL");
        } else {
            log.info("[Class Method Args] : " + Arrays.toString(args));
        }
        log.info("-------------------Request Content-------------------");
        log.info("\n");
    }
}
