package com.jiakaiyang.lintcode.java.lintcode;

/**
 * Lint Code 31
 *
 * https://www.lintcode.com/problem/partition-array/description
 */
public class No31PartitionArray {


    /***
     * @param nums: The integer array you should partition
     * @param k:    An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here

        return partition(nums, 0, nums.length - 1, k);
    }

    public int partition(int[] src, int start, int end, int key) {
        if (start >= end) {
            return start;
        }

        int indexStart = start;
        int indexEnd = end;

        while (indexStart < indexEnd) {
            while (src[indexStart] < key && indexStart < indexEnd) {
                indexStart++;

                // 说明全部在左边，这个情况要特殊处理
                if (indexStart == end) {
                    return end + 1;
                }
            }

            while (src[indexEnd] >= key && indexStart < indexEnd) {
                indexEnd--;
            }

            int tmp = src[indexStart];
            src[indexStart] = src[indexEnd];
            src[indexEnd] = tmp;
        }

        return indexStart;
    }
}
