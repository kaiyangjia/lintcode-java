package com.jiakaiyang.oj.java.lintcode;

import java.math.BigInteger;

/**
 * 14.二分查找
 * <p>
 * https://www.lintcode.com/problem/first-position-of-target/description
 * <p>
 * 描述
 * <p>
 * 给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1。
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * <p>
 * 在数组 [1, 2, 3, 3, 4, 5, 10] 中二分查找3，返回2。
 * 挑战
 * <p>
 * 如果数组中的整数个数超过了2^32，你的算法是否会出错？
 */
public class No14FirstPositionOfTarget {


    /**
     * @param nums:   The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if (nums == null) {
            return -1;
        }

        int position = binarySearchByIndex(nums, 0, nums.length - 1, target);
        if (position == -1) {
            return -1;
        }

        // find the first one.
        while (position >= 0) {
            if (position == 0) {
                return 0;
            }

            if (nums[position] == nums[position - 1]) {
                position--;
            } else {
                break;
            }
        }

        return position;
    }

    /**
     * 在指定的区间内查找指定的目标值
     *
     * @param nums   数组
     * @param start  起始位置
     * @param end    结束位置
     * @param target 目标数字
     * @return 目标数字的下标，没有找到返回 -1
     */
    public int binarySearchByIndex(int[] nums, int start, int end, int target) {
        if (nums == null
                || start < 0
                || end >= nums.length) {
            return -1;
        }

        while (start <= end) {
            // 使用long避免溢出
            int tmp = (int) (((long) start + (long) end) / 2L);
            int number = nums[tmp];

            if (number > target) {
                end = tmp - 1;
            } else if (number < target) {
                start = tmp + 1;
            } else {
                return tmp;
            }
        }

        return -1;
    }
}
