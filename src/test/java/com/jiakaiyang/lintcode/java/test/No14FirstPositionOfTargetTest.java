package com.jiakaiyang.lintcode.java.test;

import com.jiakaiyang.lintcode.java.lintcode.No14FirstPositionOfTarget;
import org.junit.Test;

/**
 * Test No14FirstPositionOfTarget
 */
public class No14FirstPositionOfTargetTest {


    @Test
    public void binarySearchByIndexTest() {
        int[] nums = {1, 4, 4, 5, 7, 7, 8, 9, 9, 10};

        No14FirstPositionOfTarget process = new No14FirstPositionOfTarget();

        int index = process.binarySearchByIndex(nums, 0, 4, 5);
        System.out.println(index);


        index = process.binarySearchByIndex(nums, 0, nums.length - 1, 7);
        System.out.println(index);


        index = process.binarySearchByIndex(nums, 0, nums.length - 1, 9);
        System.out.println(index);


        index = process.binarySearchByIndex(nums, 0, nums.length - 1, 10);
        System.out.println(index);

        index = process.binarySearchByIndex(nums, 0, nums.length - 1, 1);
        System.out.println(index);
    }


    @Test
    public void binarySearchTest() {
        int[] nums = {1, 4, 4, 5, 7, 7, 8, 9, 9, 10};

        No14FirstPositionOfTarget process = new No14FirstPositionOfTarget();

        int index = process.binarySearch(nums, 0);
        System.out.println(index);


        index = process.binarySearch(nums, 7);
        System.out.println(index);


        index = process.binarySearch(nums, 9);
        System.out.println(index);


        index = process.binarySearch(nums, 10);
        System.out.println(index);

        index = process.binarySearch(nums, 1);
        System.out.println(index);
    }
}
