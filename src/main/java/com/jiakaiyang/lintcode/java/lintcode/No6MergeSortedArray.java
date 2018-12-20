package com.jiakaiyang.lintcode.java.lintcode;

/**
 * Created by jia on 17-4-8.
 * 合并两个排序的整数数组A和B变成一个新的数组。
 *
 * https://www.lintcode.com/problem/merge-two-sorted-arrays/description
 *
 * 思路：
 * 1. 创建一个长度是两个数组总和的空数组
 * 2. 然后每一数组指定一个指针，起始都是0
 * 3. 然后开始循环遍历总数组，从A，B数组中各取一个比较，较小的值添加到总数组，并且该数组的指针移动一位。
 * 4. 如果在循环的过程中有一个为空，则直接把另一个剩下的添加到总数组的后端。
 */
public class No6MergeSortedArray {

    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public static int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here

        if (A == null
                && B == null) {
            return new int[0];
        }

        if (A == null) {
            return B;
        }

        if (B == null) {
            return A;
        }

        int[] result = new int[A.length + B.length];
        int indexA = 0, indexB = 0;
        for (int i = 0; i < result.length; i++) {
            if (A.length <= indexA) {
                result[i] = B[indexB];
                indexB++;
                continue;
            }

            if (B.length <= indexB) {
                result[i] = A[indexA];
                indexA++;
                continue;
            }

            int valueA = A[indexA];
            int valueB = B[indexB];

            if (valueA < valueB) {
                result[i] = valueA;
                indexA++;
            } else {
                result[i] = valueB;
                indexB++;
            }
        }

        return result;
    }
}
