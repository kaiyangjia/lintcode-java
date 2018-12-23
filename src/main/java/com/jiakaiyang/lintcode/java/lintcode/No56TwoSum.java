package com.jiakaiyang.lintcode.java.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 56.两数之和
 * <p>
 * https://www.lintcode.com/problem/two-sum/description
 * <p>
 * 描述
 * <p>
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * <p>
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 * <p>
 * 你可以假设只有一组答案。
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * <p>
 * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [0, 1].
 * 挑战
 * <p>
 * Either of the following solutions are acceptable:
 * <p>
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 */
public class No56TwoSum {

    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
//        return MySolution.twoSum(numbers, target);
        return SolutionWithMap.twoSum(numbers, target);
    }


    public static class MySolution {

        public static int[] twoSum(int[] numbers, int target) {
            int end = numbers.length - 1;

            int start = 0;
            while (start < end) {
                int num1 = numbers[start];

                int index2 = findTarget(numbers, start + 1, end, target - num1);
                if (index2 >= 0) {
                    int[] result = new int[2];
                    result[0] = start;
                    result[1] = index2;
                    return result;
                }

                start++;
            }

            return null;
        }

        /**
         * find index of target in the array
         *
         * @param numbers array
         * @param target  target number
         * @param start   start index
         * @param end     end index
         * @return index of target, or -1 if target do no exist.
         */
        public static int findTarget(int[] numbers, int start, int end, int target) {
            if (numbers == null
                    || start > end
                    || start < 0
                    || end >= numbers.length) {
                return -1;
            }

            for (int i = start; i <= end; i++) {
                if (numbers[i] == target) {
                    return i;
                }
            }

            return -1;
        }

    }

    /**
     * 使用一个Map存储需要的变量
     */
    public static class SolutionWithMap {

        public static int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> numberIndexMap = new HashMap<>();

            for (int i = 0; i < numbers.length; i++) {
                int num = numbers[i];

                if (numberIndexMap.containsKey(num)) {
                    // 如果已经存在，说明前一个数字已经检测过了

                    int index = numberIndexMap.get(num);

                    int[] result = new int[2];
                    result[1] = i;
                    result[0] = index;

                    return result;
                }

                numberIndexMap.put(target - num, i);
            }

            // not fount
            return new int[]{};
        }
    }
}
