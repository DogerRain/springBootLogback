package com.yudianxx.springBootDemo.model.responseVo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author huangyongwen
 * @date 2020/3/12
 * @Description 统一返回格式
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class RetResult<T> implements Serializable {

    private static final long serialVersionUID = -4505655308965878999L;

    /**
     * 错误码.
     */
    public int code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体的内容.
     */
    private T data;

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}
