package com.hac.枚举;

public enum Season {
    SPRING(1, "春天"), SUMMER(3, "夏天"), AUTUMN(5, "秋天"), WINTER(9, "冬天");

    private int index;
    private String name;

    Season(int index, String name) {
        this.index = index;
        this.name = name;
    }


    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "索引：" + getIndex() + "，值：" + getName();
    }
}

class Test {
    public static void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.println(season);
        }


        System.out.println("------------------");
        System.out.println(Season.valueOf("WINTER"));
        System.out.println(Season.SPRING.getName());
    }
}
