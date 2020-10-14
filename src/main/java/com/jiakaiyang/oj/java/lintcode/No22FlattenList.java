package com.jiakaiyang.oj.java.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 22. 平面列表
 * <p>
 * https://www.lintcode.com/problem/flatten-list/description
 *
 * <p>
 * 描述
 * <p>
 * 给定一个列表，该列表中的每个要素要么是个列表，要么是整数。将其变成一个只包含整数的简单列表。
 * <p>
 * 如果给定的列表中的要素本身也是一个列表，那么它也可以包含列表。
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * <p>
 * 给定 [1,2,[1,2]]，返回 [1,2,1,2]。
 * <p>
 * 给定 [4,[3,[2,[1]]]]，返回 [4,3,2,1]。
 * 挑战
 * <p>
 * 请用非递归方法尝试解答这道题。
 */
public class No22FlattenList {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        return Solution2.flatten(nestedList);
    }


    /**
     * 递归判断
     * 1. 承载结果的变量为 LinkedList 的时候，该方法会触发"Time Limit Exceeded" 提醒，执行时间过长
     * 2. 把LinkedList改为ArrayList 之后，就可以accept 了。
     */
    static class MySolution {

        public static List<Integer> flatten(List<NestedInteger> nestedList) {
            // LinkedList 会导致 "Time Limit Exceeded" 的错误
//            List<Integer> result = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            processList(result, nestedList);
            return result;
        }

        public static void processList(List<Integer> result, List<NestedInteger> nestedList) {
            for (NestedInteger integer : nestedList) {
                if (integer.isInteger()) {
                    result.add(integer.getInteger());
                } else {
                    List<NestedInteger> list = integer.getList();
                    if (list.size() > 0) {
                        processList(result, list);
                    }
                }
            }
        }
    }


    /**
     * 更简洁的递归
     * 1. 承载结果的变量为 LinkedList 的时候，该方法会触发"Time Limit Exceeded" 提醒，执行时间过长
     * 2. 把LinkedList改为ArrayList 之后，就可以accept 了。
     */
    static class Solution2 {
        public static List<Integer> flatten(List<NestedInteger> nestedList) {
            // LinkedList 会导致 "Time Limit Exceeded" 的错误
//            List<Integer> result = new LinkedList<>();
            List<Integer> result = new ArrayList<>();


            for (NestedInteger integer : nestedList) {
                if (integer.isInteger()) {
                    result.add(integer.getInteger());
                } else {
                    result.addAll(flatten(integer.getList()));
                }
            }

            return result;
        }


    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
