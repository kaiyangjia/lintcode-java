package com.jiakaiyang.lintcode.java.lintcode;

/**
 * LintCode 767. 翻转数组
 * https://www.lintcode.com/problem/reverse-array/description
 * <p>
 * 思路：
 * 用两个指针，分别交换首和尾的两个元素
 */
public class No767ReverseArray {

    /**
     * @param nums: a integer array
     * @return: nothing
     */
    public void reverseArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 1) {

            return;
        }

        int start = 0;
        int end = nums.length - 1;

        for (; start < end; start++, end--) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }
}
