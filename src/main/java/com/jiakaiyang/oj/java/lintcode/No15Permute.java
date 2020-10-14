package com.jiakaiyang.oj.java.lintcode;

import java.util.*;

/**
 * 15. https://www.lintcode.com/problem/permutations/description
 * 全排列
 * 描述
 * 给定一个数字列表，返回其所有可能的排列
 * Created by jia on 20-1-18.
 */
public class No15Permute {

    /**
     * 使用字典序方法来解决，即根据初始的排列，逐步获取下一个排列，知道获取到所有的
     * 等于说把全排列当做一个"数值去处理"
     * 全排列的数据范围，必然是在[1,2,3,4] -- [4,3,2,1] 之间
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        // int 转Integer
        Integer[] tmp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }

        // 初始化数据有可能是为未排序的，需要先排序
        List<Integer> initData = toList(tmp);
        Collections.sort(initData);
        initData.toArray(tmp);

        // 第一个序列
        result.add(initData);

        boolean hasNext = false;
        while (hasNext = findNext(tmp)) {
            List<Integer> l = toList(tmp);
            result.add(l);
        }

        return result;
    }

    private static List<Integer> toList(Integer[] tmp) {
        List<Integer> l = new ArrayList<>();
        for (int j = 0; j < tmp.length; j++) {
            l.add(tmp[j]);
        }
        return l;
    }

    /**
     * 使用字典序法找到下一个数列
     *
     * @param result 是否有结果
     * @return
     */
    private static boolean findNext(Integer[] result) {
        int length = result.length;
        if (length <= 1) {
            return false;
        }

        /**
         * 1. 从右边找出第一个比其右边数字小的数字 a;
         * 2. 找到 a 的右边的，所有比a大的数字中的最小数字最小数字 b;
         * 3. 交换 a 和 b；
         * 4. 把a后面的数组序列反转
         * 5. 循环以上过程
         */
        int index = length - 1;
        int b = Integer.MAX_VALUE;
        int bIndex = 0;
        while (index > 0) {
            if (result[index] > result[index - 1]) {
                // 1. 从右边查找，找到a
                int aIndex = index - 1;
                int a = result[aIndex];

                // 2. 找到a 右边比它大的数字中最小的那个，即是b
                int tmpB = result[aIndex + 1];
                bIndex = aIndex + 1;

                for (int i = aIndex + 1; i < result.length; i++) {
                    if (result[i] > a && result[i] < tmpB) {
                        tmpB = result[i];
                        bIndex = i;
                    }
                }
                b = tmpB;

                // 3. 交换a 和 b，即交换 aIndex  和 bIndex 的数字
                int tmp = result[bIndex];
                result[bIndex] = result[aIndex];
                result[aIndex] = tmp;

                // 4. 把a之后的数据进行饭庄，即反转 aIndex 之后的数组
                int[] subArray = new int[length - 1 - aIndex];
                if (subArray.length >= 2) {
                    for (int i = subArray.length - 1; i >= 0; i--) {
                        int j = subArray.length - i - 1;
                        subArray[i] = result[aIndex + 1 + j];
                    }

                    for (int i = 0; i < subArray.length; i++) {
                        result[aIndex + 1 + i] = subArray[i];
                    }
                }
                return true;
            }
            index--;
        }

        return false;
    }

    /**
     * 回溯方案
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        // 初始的路径是空的
        List<Integer> track = new LinkedList<>();

        int targetLength = nums.length;
        List<Integer> numsList = new LinkedList<>();
        for (int i = 0; i < targetLength; i++) {
            numsList.add(nums[i]);
        }
        backtrace(result, track, numsList, targetLength);
        return result;
    }

    /**
     * 回溯算法
     *
     * @param track 路径
     * @param nums  选择列表
     */
    private static void backtrace(List<List<Integer>> result
            , List<Integer> track
            , List<Integer> nums
            , int targetLength) {
        if (track.size() == targetLength) {
            // 选择列表为空，则结束回溯
            // 添加候选结果，需要copy 一个数据，因为track 会在途中更改
            List<Integer> copyTrack = new LinkedList<>(track);
            result.add(copyTrack);
            return;
        }


        for (int n : nums) {
            // 添加一个元素
            track.add(n);

            // 进行下一层的树，获取下一层的选择条件
            int size = nums.size();
            List<Integer> nextNums = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                int nextN = nums.get(i);
                if (nextN != n) {
                    nextNums.add(nextN);
                }
            }

            backtrace(result, track, nextNums, targetLength);

            // 移除元素
            track.remove(track.size() - 1);
        }
    }
}
