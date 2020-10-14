package com.jiakaiyang.oj.java.lintcode.test;

import com.jiakaiyang.oj.java.lintcode.No16Permute2;
import org.junit.Test;

import java.util.List;

public class No16PermuteTest {
    @Test
    public void TestPermute() {
        int[] data = new int[]{2, 2, 4, 4, 7};

        System.out.println("回溯算法");

        List<List<Integer>> result = No16Permute2.permuteUnique(data);
        System.out.println(result);
    }
}
