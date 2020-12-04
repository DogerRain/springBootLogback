package com.yudianxx.common.result;

public enum RetCode {
    // 成功
    SUCCESS(200),

    SUCCESS_MSG(200, "成功"),

    // 失败
    FAIL(400),

    // 未认证（签名错误）
    UNAUTHORIZED(401),

    // 接口不存在
    NOT_FOUND(404),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500),


    S_REDIRECT(300, "重定向"),

    S_ERROR(1001, "系统错误"),

    S_SERVICE_PAUSE(1002, "服务暂停"),

    S_SERVICE_BUSY(1003, "服务器忙"),

    S_INTERFACE_ERROR(1004, "接口不存在"),

    S_INTERFACE_TIMEOUT(1005, "接口超时"),

    /**
     * W_开头为WEB层
     */
    W_ILLEGAL_ARGUMENT(110000, "缺少参数"),
    W_USER_NOT_EXISTS(110001, "用户不存在"),
    W_PASSWORD_ERROR(110002, "密码错误"),
    W_SESSION_INVALIDATION(110003, "会话失效"),

    APP_USERPASS_EMPTY(110006, "用户名密码不能为空"),
    APP_USERNAME_ERROR(110007, "用户名格式错误，只能大小写和下划线，最多128字符"),
    APP_USERNAME_EXISTS(11008, "用户名已存在");


    public int code;
    public String msg;

    RetCode(int code) {
        this.code = code;
    }

    RetCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    int getCode() {
        return code;
    }

    String getName() {
        return msg;
    }
}
