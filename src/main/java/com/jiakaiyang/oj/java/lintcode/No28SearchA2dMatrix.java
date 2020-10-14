package com.jiakaiyang.oj.java.lintcode;

/**
 * https://www.lintcode.com/problem/search-a-2d-matrix/description
 * 28. 搜索二维矩阵
 * 描述
 * 写出一个高效的算法来搜索 m × n矩阵中的值。
 * <p>
 * 这个矩阵具有以下特性：
 * <p>
 * 1. 每行中的整数从左到右是排序的。
 * 2. 每行的第一个数大于上一行的最后一个整数。
 * <p>
 * <p>
 * Created by jia on 18/1/2020
 * github: https://github.com/kaiyangjia
 */
public class No28SearchA2dMatrix {
    /**
     * 由于多维数组中的都是已经排序过的，所以可以使用分治的思路
     * 1. 先取每个子数组中的第一个数字来判断，确定目标数字是在哪个子数组中
     * 2. 然后在这个子数组中使用二分查找来找到目标
     *
     */

    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        if (matrix[0].length == 0) {
            return false;
        }

        int length = matrix.length;
        int index = -1;
        for (int i = 0; i < length; i++) {
            int start = matrix[i][0];
            if (start == target) {
                return true;
            }
            if (target < start) {
                // 如果 targt 小于某一个起始值，说明target 在上一个数组中
                index = i - 1;
                break;
            }
        }

        if (index < 0) {
            // 如果index 小于0，说明target 不小于任何一个子数组的开头
            // 这个时候，如果target 存在，也只可能是在最后一个子数组中
            // 所以可以直接在最后一个子数组中搜索就可以
            int[] lastArray = matrix[length - 1];
            return binarySearch(lastArray, 0, lastArray.length - 1, target);
        }

        int[] array = matrix[index];
        return binarySearch(array, 0, array.length - 1, target);
    }

    private static boolean binarySearch(int[] src, int fromIndex, int toIndex, int target) {
        if (src == null || src.length == 0) {
            return false;
        }

        int length = src.length;
        if (length == 1) {
            return src[0] == target;
        }

        int low = fromIndex;
        int high = toIndex;

        while (high >= low) {
            // 右移一位代替除以2
            int mid = (high + low) >>> 1;
            int midValue = src[mid];

            if (midValue > target) {
                high = mid - 1;
            } else if (midValue < target) {
                // 把mid 的这一位直接跳过，而且可以避免当 high 比low 大于1 的时候的死循环
                // 比如：high=3；low=2的时候，计算出 mid=2，这样会导致mid 永远停留在低位，无法往前移动
                low = mid + 1;
            } else {
                // midValue == target
                return true;
            }
        }

        return false;
    }
}
