package com.jiakaiyang.oj.java.lintcode.test;

import com.jiakaiyang.oj.java.lintcode.No56TwoSum;
import org.junit.Test;

public class No56TwoSumTest {

    @Test
    public void MySolution_findTargetTest() {
        int[] numbers = {0, 4, 3, 0};


        int result = -2;
        result = No56TwoSum.MySolution.findTarget(numbers, 1, 3, 0);
        System.out.println(result);
    }
}
