package com.yudianxx.common.annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yudianxx.common.AddressUtil;
import com.yudianxx.common.HttpContextUtil;
import com.yudianxx.common.IPUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

@Component
@Aspect
@Order(100)
public class PointCutAspect {

    static final Logger logger = Logger.getLogger(PointCutAspect.class);

    /**
     * 指定切面
     */
//    @Pointcut("execution(public * com.meizu.gemini.web.controller.FileController.*(..))")
    private void pointCut() {

    }

    //    @Around("@annotation(TimeConsume)&&pointCut()")  //且关系，两者满足会执行
    @Around("@annotation(com.yudianxx.common.annotation.TimeConsume)")
    public Object TimeConsumePoincut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        TimeConsume timeConsume = method.getAnnotation(TimeConsume.class);
        //这个方法才是目标对象上有注解的方法
        Method realMethod = proceedingJoinPoint.getTarget().getClass().getDeclaredMethod(proceedingJoinPoint.getSignature().getName(), method.getParameterTypes());
        TimeConsume realTimeConsume = realMethod.getAnnotation(TimeConsume.class);
        if (timeConsume == null) {
            timeConsume = realTimeConsume;
        }
        Long statrtTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        logger.info("-------------end-----------》》》》》》》》 AOP切面拦截，当前调用类：" + proceedingJoinPoint.getSignature().getDeclaringTypeName()
                + "，调用方法：" + timeConsume.methodName()
                + "，操作描述：" + timeConsume.description() + "，耗时--------》--》" + (endTime - statrtTime) + " 毫秒");
        return result;
    }

    @Pointcut("@annotation(com.yudianxx.common.annotation.Log)")
    public void pointcutLog() {
    }

    @Around("pointcutLog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws JsonProcessingException, UnsupportedEncodingException {
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //获取Request请求
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        //设置IP地址
        String ip = AddressUtil.getIpAddress(request);
        String detail = AddressUtil.getAddress(ip);
        //入库
        return result;
    }
}