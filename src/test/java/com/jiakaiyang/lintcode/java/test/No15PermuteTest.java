package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No15Permute;
import org.junit.Test;

import java.util.List;

public class No15PermuteTest {
    @Test
    public void TestPermute() {
        int[] data = new int[]{3, 2, 4};
        List<List<Integer>> result = No15Permute.permute(data);
        System.out.println(result);
    }
}
