package com.yudianxx.common;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


public class HttpContextUtil {
    private HttpServletRequest request; //此处线程不安全
    @ModelAttribute
    public void bindRequest(HttpServletRequest request) {
        this.request = request; //此处request线程安全
    }

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
