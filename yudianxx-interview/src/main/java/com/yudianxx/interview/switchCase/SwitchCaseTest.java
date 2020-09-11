package com.yudianxx.interview.switchCase;

/**
 * @author huangyongwen
 * @date 2020/9/9
 * @Description
 */
public class SwitchCaseTest {
    public static void main(String[] args) {
        int num = 2;
        switch (num) {
            case 1:
                num++;
            case 2:
                num++;
            case 3:
                num++;
            default:
                num++;
                break;
        }
        System.out.println(num);
    }
}
// 从 case 2 开始匹配
//只要没有break ，就一直往下渗透，包括default