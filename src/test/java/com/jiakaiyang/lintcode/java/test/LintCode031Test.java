package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.LintCode031;
import org.junit.Test;

public class LintCode031Test {

    @Test
    public void Test() {
        int[] nums = new int[]{7, 7, 9, 8, 6, 6, 8, 7, 9, 8, 6, 6};
        LintCode031 lintCode031 = new LintCode031();
        int result = lintCode031.partitionArray(nums, 10);
    }
}
