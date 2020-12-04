package com.yudianxx.basic.Junit;

import org.junit.*;

/**
 * @author huangyongwen
 * @date 2020/11/12
 * @Description
 */
public class JunitTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass");
    }
    @After
    public void after2() {
        System.out.println("After2");
    }

    @After
    public void after1() {
        System.out.println("After1");
    }
    @Before
    public void before1() {
        System.out.println("Before1");
    }


    @Test
    public void test() {
        System.out.println("Test");
    }

    @Before
    public void before2() {
        System.out.println("Before2");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass");
    }
}
