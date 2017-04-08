package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.MergeSortedArray;
import org.junit.Test;

/**
 * Created by jia on 17-4-8.
 */
public class MergeSortedArrayTest {

    @Test
    public void TestResult() {
        int[] a = new int[]{2, 4, 5, 6, 7};
        int[] b = new int[]{1, 2, 3, 8, 9, 10};

        int[] result = MergeSortedArray.mergeSortedArray(a, b);
        if (result != null) {

        }
    }
}
