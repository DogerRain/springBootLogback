package com.yudianxx.springBootDemo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    //表示用来拦截这个Log类，即使用了@Log注解的类
    @Pointcut("@annotation(com.yudianxx.springBootDemo.annotation.Log)")
    public void pointCut() {}

    //拦截点，表示拦截该包包括子包下面所有public的方法
    @Pointcut("execution(public * com1.yudianxx.springBootDemo.controller.*.*(..))")
    public void signAop() {
    }
    @Around("signAop()")
//    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        this.saveLog(point);
        return result;
    }

    @Before("signAop()")
    public void dobefore(JoinPoint joinPoint){
        log.info("我是before");
        log.info(joinPoint.getSignature().getName());
    }

    //不知道为什么没有执行
    @AfterReturning(value = "signAop()", returning = "retVal1")
    public String  doAfterReturning(JoinPoint joinPoint ,String retVal1 ) {
        log.info("我是afterReturning");
        return "";
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
    }
}
