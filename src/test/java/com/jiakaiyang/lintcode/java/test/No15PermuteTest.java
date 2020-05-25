package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No15Permute;
import org.junit.Test;

import java.util.List;

public class No15PermuteTest {
    @Test
    public void TestPermute() {
        int[] data = new int[]{4, 3, 2, 1};
        List<List<Integer>> result = No15Permute.permute(data);
        System.out.println(result);

        System.out.println("回溯算法");

        result = No15Permute.permute2(data);
        System.out.println(result);
    }
}
