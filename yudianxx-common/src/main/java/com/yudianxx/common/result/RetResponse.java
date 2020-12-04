package com.yudianxx.common.result;

/**
 * @author huangyongwen
 * @date 2020/3/12
 * @Description
 */
public class RetResponse {
    public final static String SUCCESS = "success";
    public final static String FAIL = "服务器出错了，请稍后重试";

    public static <T> RetResult<T> makeOKRsp() {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> RetResult<T> makeOKRsp(T data) {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> RetResult<T> makeErrRsp(String message) {
        return new RetResult<T>().setCode(RetCode.FAIL).setMsg(message);
    }

    public static <T> RetResult<T> makeRsp(int code, String msg) {
        return new RetResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> RetResult<T> makeRsp(int code, String msg, T data) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
    }

    public static <T> RetResult<T> makeUnKnowRsp() {
        return new RetResult<T>().setCode(RetCode.INTERNAL_SERVER_ERROR).setMsg(FAIL);
    }

    public static <T> RetResult<T> makeOkRspCodeAndMsg(RetCode Code) {
        return new RetResult<T>().setCodeAndMsg(Code);
    }

}
