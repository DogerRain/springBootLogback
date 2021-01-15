package com.hac.异常;

/**
 * @author huangyongwen
 * @date 2021/1/15
 * @Description
 */
public class Car {

}

class WuLingHongGuang{
    private String[] weels = {"左1", "左2", "后1", "后2","备胎1"};

    void addWeel(int index, String weelName) {
        weels[index] = weelName;
    }

    void drive() {
        System.out.println("五菱宏光发动机正在运行中......");
    }
}

class HaC {
    public static void main(String[] args) {
        WuLingHongGuang wuLingHongGuang = new WuLingHongGuang();
        wuLingHongGuang.addWeel(10, "备胎2");
    }
}

