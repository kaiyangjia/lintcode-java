package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.Fibonacci;
import org.junit.Test;

/**
 * Created by jia on 17-4-8.
 */
public class FibonacciTest {


    @Test
    public void TestResult(){

        int result3 = Fibonacci.fibonacci(3);
        int result13 = Fibonacci.fibonacci(13);
        int result24 = Fibonacci.fibonacci(24);
        int result2 = Fibonacci.fibonacci(2);

        System.out.println(result3+" " + result13 +" " +result24 + " " + result2);
    }
}
