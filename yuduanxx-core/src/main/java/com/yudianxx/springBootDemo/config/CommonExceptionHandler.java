package com.yudianxx.springBootDemo.config;

import com.yudianxx.springBootDemo.model.responseVo.RetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import com.yudianxx.springBootDemo.model.responseVo.RetResult;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author huangyongwen
 * @date 2020/8/28
 * @Description 统一异常处理
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    // 参数校验失败抛出的异常
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public RetResult handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        return RetResponse.makeErrRsp(msg);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public RetResult handleConstraintViolationException(ConstraintViolationException ex) {
        return RetResponse.makeErrRsp(ex.getMessage());
    }

    /**
     * 最终Exception处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    RetResult handleException(Exception e) {
        log.error("出错啦：", e);
        return RetResponse.makeErrRsp(RetResponse.FAIL);
    }
}
