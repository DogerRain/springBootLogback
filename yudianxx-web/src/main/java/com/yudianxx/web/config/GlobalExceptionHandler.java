package com.yudianxx.web.config;

import com.yudianxx.common.result.RetResponse;
import com.yudianxx.common.result.RetResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * @author huangyongwen
 * @date 2020/3/13
 * @Description 全局controller异常捕捉
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    RetResult handleValidationException(ConstraintViolationException e) {
        String errorMessage = "";
        for (ConstraintViolation<?> s : e.getConstraintViolations()) {
            errorMessage += s.getInvalidValue() + ": " + s.getMessage();
        }
        return RetResponse.makeErrRsp(errorMessage);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    RetResult handleException(Exception e) {
        log.error("出错啦：", e);
        return RetResponse.makeErrRsp(RetResponse.FAIL);
    }
}
