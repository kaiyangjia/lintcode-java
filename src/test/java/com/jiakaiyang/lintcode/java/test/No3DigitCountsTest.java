package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No3DigitCounts;
import org.junit.Test;

public class No3DigitCountsTest {

    @Test
    public void TestDigitCounts(){
        // 5 15 25 35 45 55
        int result = No3DigitCounts.solution(5, 55);
        System.out.println(result);
    }
}
