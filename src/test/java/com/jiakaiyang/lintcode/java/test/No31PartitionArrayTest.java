package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No31PartitionArray;
import org.junit.Test;

public class No31PartitionArrayTest {

    @Test
    public void Test() {
        int[] nums = new int[]{7, 7, 9, 8, 6, 6, 8, 7, 9, 8, 6, 6};
        No31PartitionArray no31PartitionArray = new No31PartitionArray();
        int result = no31PartitionArray.partitionArray(nums, 10);
    }
}
