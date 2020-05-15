package com.jiakaiyang.lintcode.java.lintcode;

import java.util.*;

/**
 * 16. 带重复元素的排列
 * https://www.lintcode.com/problem/permutations-ii/description
 * <p>
 * 给出一个具有重复数字的列表，找出列表所有不同的排列。
 * <p>
 * Created by jia on 15/5/2020
 * github: https://github.com/kaiyangjia
 */
public class No16Permute2 {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        int targetLength = nums.length;
        List<Integer> numList = toList(nums);
        List<Integer> trace = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        backtrace(result, trace, numList, targetLength);

        return result;
    }


    /**
     * 使用回溯算法，基于非重复元素的全排列
     *
     * @param result       存放结果
     * @param trace        路径
     * @param nums         选择列表
     * @param targetLength 路径的最终长度，达到该长度则结束回溯
     */
    private static void backtrace(List<List<Integer>> result
            , List<Integer> trace
            , List<Integer> nums
            , int targetLength) {
        if (targetLength == trace.size()) {
            result.add(new ArrayList<>(trace));
            return;
        }

        // 给带有重复元素的选择列表去重，去重后的为决策树的子结点
        Set<Integer> numsSet = new HashSet<>(nums);
        for (int i : numsSet) {
            trace.add(i);

            // 获取下一层的选择列表，带有重复元素的选择列表
            // 是需要从当前的选择列表中移除一个i，而且只能移除一个
            List<Integer> nextNums = new LinkedList<>(nums);
            // 移除最后一个出现的i
            int removeResult = nextNums.lastIndexOf(i);
            if (removeResult != -1) {
                nextNums.remove(removeResult);
            } else {
                throw new IllegalStateException("There is something wrong");
            }

            backtrace(result, trace, nextNums, targetLength);

            // 移除添加的元素
            trace.remove(trace.size() - 1);
        }
    }

    static List<Integer> toList(int[] tmp) {
        int length = tmp.length;
        List<Integer> l = new ArrayList<>(length);
        for (int j = 0; j < length; j++) {
            l.add(tmp[j]);
        }
        return l;
    }
}
