package com.jiakaiyang.lintcode.java.lintcode;

/**
 * 463. 整数排序
 * https://www.lintcode.com/problem/sort-integers/description
 * <p>
 * 描述
 * 给一组整数，按照升序排序，使用选择排序，冒泡排序，插入排序或者任何 O(n2) 的排序算法。
 * <p>
 * Created by jia on 14/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No463SortIntegers {

    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // write your code here
        if (A == null) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }

    /**
     * 快速排序
     *
     * @param array
     * @param start
     * @param end
     */
    private void quickSort(int[] array, int start, int end) {
        int length = array.length;
        // System.out.println("start: " + start + ", end: " + end + ", length: " + length);
        if (end - start < 1) {
            return;
        }

        if (start < 0 || start >= length) {
            return;
        }

        if (end < 0 || end >= length) {
            return;
        }


        int tmp = array[start];
        int left = start, right = end;

        // System.out.println("tmp: " + tmp);
        while (left < right) {
            while (left < right && array[right] > tmp) {
                right--;
            }

            while (left < right && array[left] < tmp) {
                left++;
            }

            // 处理可能存在想等数值，避免出现死循环
            if (array[left] == array[right] && left != right) {
                left++;
            }

            // System.out.println("find left: " + left + ", right: " + right);
            swap(array, left, right);
        }

        if (start < left - 1) {
            quickSort(array, start, left - 1);
        }

        if (left + 1 < end) {
            quickSort(array, left + 1, end);
        }
    }

    // 交换数组中两个位置的数据，需要外部保证参数的合法性，内部不做判断
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
