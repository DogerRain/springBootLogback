package com.yudianxx.basic.运算符;

import java.math.BigDecimal;

/**
 * @author huangyongwen
 * @date 2020/10/13
 * @Description
 */
public class BigdecimalTest {
    public static void main(String[] args) {
        BigDecimal tcpConnectTime = new BigDecimal("0.05".trim()).subtract(new BigDecimal("0.02".trim())).multiply(new BigDecimal("1000")).setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println(tcpConnectTime);
    }
}
