package org.lesson1.tester;

import org.lesson1.tester.annotation.*;

public class MyTest {
    @Before
    public void before1(){
        System.out.println("before 1");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test (expectedException = IllegalArgumentException.class, expectedMessage = "exception")
    public void test3(){
        throw new IllegalArgumentException("exception");

    }

    private void noTest(){
        System.out.println("no a test");
    }

    @After
    public void after1(){
        System.out.println("after 1");
    }

    @BeforeAll
    public void beforeAll() {System.out.println("beforeAll 1");}

    @AfterAll
    public void afterAll() {System.out.println("afterAll 1");}

}
