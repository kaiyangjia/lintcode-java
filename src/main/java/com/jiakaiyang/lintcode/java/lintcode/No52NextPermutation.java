package com.jiakaiyang.lintcode.java.lintcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 52. 下一个排列
 * https://www.lintcode.com/problem/next-permutation/description
 * <p>
 * 描述
 * 给定一个整数数组来表示排列，找出其之后的一个排列。
 *
 * @see No15Permute
 * Created by jia on 1/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No52NextPermutation {

    /**
     * 找到找到排列的下一个数字，基于以下步骤：
     * 1. 从右向左依次查找，找到第一个数字a小于它右侧的数字，记a的下标为 indexA;
     * 2. 找到a 之后，那么在a右侧的序列必然是一个降序的排列；降序排列在它的全排列中是最大的；
     * 3. 从indexA + 1 的位置开始（即a的右边所有的数字），查找目标b，目标b是"a右边所有大于a的数字中的最小值"，并记b的下标为indexB；
     * 4. 交换 indexA 和 indexB中的内容，这个时候在 indexA右边的序列必然仍然是降序的；
     * 5. 把indexA右边的序列整个反转，得到的即是目标
     *
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public static int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int indexA = -1, indexB = -1;

        // 1. 从右向左依次查找，找到第一个数字a小于它右侧的数字，记a的下标为 indexA;
        // 2. 找到a 之后，那么在a右侧的序列必然是一个降序的排列；降序排列在它的全排列中是最大的；
        int i = nums.length - 1;
        while (i >= 1) {
            if (nums[i - 1] < nums[i]) {
                indexA = i - 1;
                break;
            }
            i--;
        }

        System.out.println("indexA: " + indexA);

        // check indexA，如果没有找到合法的indexA, 说明该序列是完全倒序的，直接把数组反转即得到结果
        if (indexA < 0) {
            reverseArray(nums, 0, nums.length - 1);
            return nums;
        }

        // 3. 从indexA + 1 的位置开始（即a的右边所有的数字），查找目标b，目标b是"a右边所有大于a的数字中的最小值"，并记b的下标为indexB；
        int a = nums[indexA];
        int j = indexA;

        // 设置初始的 indexB的值
        indexB = indexA + 1;
        int b = nums[indexB];


        while (j < nums.length) {
            int tmp = nums[j];
            // 这里在tmp == b 的时候也继续替换，是为了应对序列中存在相同数字的情况
            if (tmp > a && tmp <= b) {
                b = tmp;
                indexB = j;
            }
            j++;
        }

        System.out.println("indexB: " + indexB);

        // 4. 交换 indexA 和 indexB中的内容，这个时候在 indexA右边的序列必然仍然是降序的；
        int tmp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = tmp;

        // 5. 把indexA右边的序列整个反转，得到的即是目标
        reverseArray(nums, indexA + 1, nums.length - 1);
        return nums;
    }

    /**
     * 反转一个数组的一部分，在该算法的第5步中会使用到
     *
     * @param array 需要被操作的数组
     * @param start 需要反转的起始的下标
     * @param end   需要反转的结束的下标
     * @return
     */
    private static void reverseArray(int[] array, int start, int end) {
        int length = 0;
        if (array == null || (length = array.length) <= 1) {
            return;
        }

        if (start < 0 || end >= length) {
            return;
        }

        int step = (end - start) + 1;
        int[] tmp = new int[step];
        for (int i = 0; i < step; i++) {
            tmp[step - i - 1] = array[start + i];
        }


        for (int i = 0; i < step; i++) {
            array[start + i] = tmp[i];
        }
    }

}
