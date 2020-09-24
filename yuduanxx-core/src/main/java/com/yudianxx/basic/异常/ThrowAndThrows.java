package com.yudianxx.basic.异常;

/**
 * @author huangyongwen
 * @date 2020/9/18
 * @Description
 */
public class ThrowAndThrows {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1*1000);
        //throws 是在类抛出的异常

        //throw  是在 方法体中抛出的
        try{
            throw new RuntimeException("运行时异常");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
