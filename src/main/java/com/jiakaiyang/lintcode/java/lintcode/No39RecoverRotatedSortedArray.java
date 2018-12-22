package com.jiakaiyang.lintcode.java.lintcode;

import java.util.List;

/**
 * lintcode 39
 * <p>
 * https://www.lintcode.com/problem/recover-rotated-sorted-array/description
 * <p>
 * 39. 恢复旋转排序数组
 * <p>
 * 给定一个旋转排序数组，在原地恢复其排序。
 * 样例
 * <p>
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * 挑战
 * <p>
 * 使用O(1)的额外空间和O(n)时间复杂度
 * 说明
 * <p>
 * 什么是旋转数组？
 * <p>
 * 比如，原始数组为[1,2,3,4], 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 */
public class No39RecoverRotatedSortedArray {

    /**
     * My Solution:
     * 1. 找到大小相反的位置 minIndex
     * 2. 循环左移（使用反转数组实现循环左移）
     *
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        int minNumberIndex = findMinIndex(nums);
        loopLeftShift(nums, minNumberIndex);
    }


    /**
     * find the min number index
     *
     * @param nums
     * @return
     */
    public int findMinIndex(List<Integer> nums) {
        if (nums.size() == 1) {
            return 0;
        }

        for (int i = 0; i < nums.size(); i++) {
            // the last time
            if (i == nums.size() - 1) {
                return 0;
            }

            if (nums.get(i) > nums.get(i + 1)) {
                return i + 1;
            }
        }

        return 0;
    }

    /**
     * 向左循环位移 n 位
     * <p>
     * simple
     * 假如原数组： 1 2 3 4 5 6 7 需要右移4次，那么我们想要的结果是： 5 6 7 1 2 3 4。
     * 1.将1234逆置 变成 4321
     * 2.将567逆置 变成 765
     * 3.将两个逆置数组拼接： 4321765
     * 4.将这个已拼接的数组逆置： 5671234 就成了我们想要的结果了。
     * <p>
     * <p>
     * so,
     * 1. reverse(0, count - 1);
     * 2. reverse(count, length - 1);
     * 3. reverse(0, length - 1);
     *
     * @param nums  被操作的列表或者数组
     * @param count 位移的位数
     */
    public void loopLeftShift(List<Integer> nums, int count) {
        if (count >= nums.size()) {
            count = count % nums.size();
        }

        if (count == 0) {
            return;
        }

        reverse(nums, 0, count - 1);
        reverse(nums, count, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }


    /**
     * reverse part of array or list
     *
     * @param nums  target list
     * @param start start index
     * @param end   end index
     */
    public void reverse(List<Integer> nums, int start, int end) {
        if (nums.size() < 2) {
            return;
        }

        if (start < 0 || end >= nums.size()) {
            // wrong params
            return;
        }

        for (; start < end; start++, end--) {
            int tmp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
        }
    }
}
