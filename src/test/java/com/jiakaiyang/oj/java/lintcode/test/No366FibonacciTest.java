package com.jiakaiyang.oj.java.lintcode.test;

import com.jiakaiyang.oj.java.lintcode.No366Fibonacci;
import org.junit.Test;

/**
 * Created by jia on 17-4-8.
 */
public class No366FibonacciTest {


    @Test
    public void TestResult(){

        int result3 = No366Fibonacci.fibonacci(3);
        int result13 = No366Fibonacci.fibonacci(13);
        int result24 = No366Fibonacci.fibonacci(24);
        int result2 = No366Fibonacci.fibonacci(2);

        System.out.println(result3+" " + result13 +" " +result24 + " " + result2);
    }
}
