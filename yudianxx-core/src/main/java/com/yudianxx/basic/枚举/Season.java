package com.yudianxx.basic.枚举;

/**
 * @author huangyongwen
 * @date 2020/5/22
 * @Description
 */
public enum Season {
    // 定义四个枚举实例
    SPRING(1, "春"), SUMMER(2, "夏"), AUTUMN(3, "秋"), WINTER(4, "冬");

    private final int id;
    private final String name;

    Season(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String myString(){
        return "a";
    }


    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.AUTUMN.getName());
        for (Season s : Season.values()) {
            System.out.println(s);
        }

//        String a = myString();
//        switch ("1"){
//            case a:
//        }


    }
}

