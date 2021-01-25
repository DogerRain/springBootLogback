package com.hac.常用类;

import java.math.BigDecimal;

/**
 * @author huangyongwen
 * @date 2021/1/25
 * @Description
 */
public class BigDecimalTest {
    static class Test {
        public static void main(String[] args) {
//            double d =0.03;
//            double d2 =300.03;
//            System.out.println(d + d2); // 300.05999999999995 ,但是结果理应是  301.06
            BigdecimalTest();
        }
    }

    static void BigdecimalTest() {
        BigDecimal num1 = new BigDecimal(1);
        BigDecimal num2 = new BigDecimal(3);
        System.out.println(num1.divide(num2, BigDecimal.ROUND_DOWN));
    }

    static void MathTest(){
        double x = Math.random(); // x的范围是[0,1)
    }
}

