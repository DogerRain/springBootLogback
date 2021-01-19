package com.hac.异常;

/**
 * @author huangyongwen
 * @date 2021/1/15
 * @Description
 */

class ChangeWeelException extends RuntimeException {
    private int errorCode;
    private String errorMessage;

    ChangeWeelException(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}


public class WuLingHongGuang {
    private String[] weels = {"左1", "左2", "后1", "后2", "备胎1"};

    void changeWeel(int index, String weelName) throws ChangeWeelException { //throws 关键字，表示方法可能会抛出异常
        if (index > weels.length) {
            throw new ChangeWeelException(50001, "ERROR！！！轮胎安装位置错误了！"); //throw 关键字，直接抛出异常
        } else {
            weels[index] = weelName;
        }
    }

    void drive() {
        System.out.println("五菱宏光发动机正在运行中......");
    }
}

class HaC {
    public static void main(String[] args) {
        WuLingHongGuang wuLingHongGuang = new WuLingHongGuang();
//        wuLingHongGuang = null;
        try {
            wuLingHongGuang.changeWeel(10, "备胎2"); //捕获异常
            System.out.println("更换成功"); //报错并不会执行
        } catch (ChangeWeelException e) {
            e.printStackTrace();
            System.out.println("错误码：" + e.getErrorCode());
            System.out.println("错误提示：" + e.getErrorMessage());
        } finally {
            System.out.println("更换完毕...");
        }
    }

}


