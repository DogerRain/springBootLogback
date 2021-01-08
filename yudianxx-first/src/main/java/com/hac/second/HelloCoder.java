package com.hac.second;

/**
 * @author huangyongwen
 * @date 2021/1/8
 * @Description
 */
public class HelloCoder {
    public static void main(String args[]) {
        /*for (int x = 5; x >= 1; x--) {
            System.out.println("x的值：" + x);
        }*/
    }

    /*static {
        int x = 5;
        for (; x >= 1; ) {
            System.out.println("x的值：" + x);
            x--;
        }
    }

    static {
        int[] numbers = {5, 4, 3, 2, 1};
        for (int num : numbers) {
            System.out.println("num:" + num);
        }
    }

    static {
        int x = 10;
        if (x == 10) {
            System.out.println("x等于10");
        }
        if (x > 20) {
            System.out.println("x大于20");
        } else {
            System.out.println("x小于20");
        }
    }

    static {
        int x = 10;
        if (x == 40) {
            System.out.println("x等于30");
        } else if (x == 20) {
            System.out.println("x等于20");
        } else if (x == 10) {
            System.out.println("x等于10");
        } else {
            System.out.println("都不是");
        }
    }

    static {
        int x = 9;
        if (x < 10) {
            if (x < 5) {
                System.out.println("x小于10且小于5");
            } else {
                System.out.println("x大于5且小于10");
            }
        } else {
            System.out.println("x大于10");
        }
    }

    static {
        String grade = "B";
        switch (grade) {
            case "A":
                System.out.println("优秀");
                break;
            case "B":
            case "C":
                System.out.println("良好");
                break;
            case "D":
                System.out.println("及格");
                break;
            case "F":
                System.out.println("不及格");
                break;
            default:
                System.out.println("回家小心点");
        }
    }
    static {
        int i = 1;
        switch(i){
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            default:
                System.out.println("default");
        }
    }*/

    static {
        for (int x = 2; x >= 1; x--) {
            for (int y = 1; y <= 3; y++) {
                if (x == 1 && y == 2) {
                    break;
                }
                System.out.println("x的值：" + x + "，y的值：" + y);
            }
        }
    }

}