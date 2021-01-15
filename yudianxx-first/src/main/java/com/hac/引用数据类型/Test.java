package com.hac.引用数据类型;

/**
 * @author huangyongwen
 * @date 2021/1/14
 * @Description
 */

class HaC {
    String name;

    public static void main(String[] args) {
        int age = 25;
        String[] interests = {"打代码"};
        int[] scores ={100};
        HaC haC = new HaC();
        haC.name = "HaC";

        System.out.println("我的名字:" + haC.name + "，年龄：" + age + "，我的兴趣之一：" + interests[0] + "，分数：" + scores[0]);

        changeName(haC);
        changeAge(age);
        changeInterests(interests);
        changeScores(scores);
        System.out.println("-----修改后------");

        System.out.println("我的名字:" + haC.name + "，年龄：" + age + "，我的兴趣之一：" + interests[0] + "，分数：" + scores[0]);

    }

    static void changeName(HaC haC) {
        haC.name = "哈C";
    }

    static void changeAge(int age) {
        age = 18;
    }

    static void changeInterests(String interests[]) {
        interests[0] = "开车";
    }

    static void changeScores(int scores[]) {
        int[] newScores ={60};
        scores = newScores;
    }
}



