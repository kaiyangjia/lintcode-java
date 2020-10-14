package com.jiakaiyang.oj.java.lintcode.test;

import com.jiakaiyang.oj.java.lintcode.No39RecoverRotatedSortedArray;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No39RecoverRotatedSortedArrayTest {

    private static List<Integer> nums = new LinkedList();

    static {
        nums.addAll(Arrays.asList(4, 5, 6, 7, 1, 2, 3));
    }

    @Test
    public void reverseTest() {
        No39RecoverRotatedSortedArray process = new No39RecoverRotatedSortedArray();
        process.reverse(nums, 0, 3);
        System.out.println(nums);
        process.reverse(nums, 4, 6);
        System.out.println(nums);
    }

    @Test
    public void loopRightShiftTest() {
        No39RecoverRotatedSortedArray process = new No39RecoverRotatedSortedArray();

        process.loopLeftShift(nums, 2);
        System.out.println(nums);

        process.loopLeftShift(nums, 5);
        System.out.println(nums);

        process.loopLeftShift(nums, 20);
        System.out.println(nums);
    }

    @Test
    public void recoverRotatedSortedArrayTest() {
        No39RecoverRotatedSortedArray process = new No39RecoverRotatedSortedArray();

        List<Integer> nums1 = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
        process.recoverRotatedSortedArray(nums1);
        System.out.println(nums1);

        List<Integer> nums2 = Arrays.asList(4, 1, 2, 3);
        process.recoverRotatedSortedArray(nums2);
        System.out.println(nums2);

        List<Integer> nums3 = Arrays.asList(1, 2, 3);
        process.recoverRotatedSortedArray(nums3);
        System.out.println(nums3);
    }
}
