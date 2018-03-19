package com.jiakaiyang.lintcode.java;

/**
 * Lint Code 31
 * <p>
 * 给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
 * <p>
 * 所有小于k的元素移到左边
 * 所有大于等于k的元素移到右边
 * 返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
 * <p>
 * 注意事项
 * 你应该真正的划分数组 nums，而不仅仅只是计算比 k 小的整数数，如果数组 nums 中的所有元素都比 k 小，则返回 nums.length。
 */
public class LintCode031 {


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
