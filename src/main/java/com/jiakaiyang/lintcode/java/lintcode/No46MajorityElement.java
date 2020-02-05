package com.jiakaiyang.lintcode.java.lintcode;

import java.util.*;

/**
 * 46. 主元素
 * https://www.lintcode.com/problem/majority-element/description
 * <p>
 * 描述
 * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 * 你可以假设数组非空，且数组中总是存在主元素。
 * <p>
 * Created by jia on 2/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No46MajorityElement {

    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public static int majorityNumber(List<Integer> nums) {
        // write your code here
//        return solutionWithMap(nums);
//        return solution2(nums);
        return solution3(nums);
    }

    /**
     * 使用Map计数来得到结果的解决方案
     * 思路：使用Map保存所有的数字的count值，取其中的最大值即可
     *
     * @param nums
     * @return
     */
    private static int solutionWithMap(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = nums.size();

        for (Integer i : nums) {
            int currentCount;
            currentCount = map.getOrDefault(i, 0);
            currentCount++;

            map.put(i, currentCount);
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        int maxCount = -1;
        Integer target = null;
        for (Map.Entry<Integer, Integer> entry : set) {
            int value = entry.getValue();
            // 主要数字的数量必然是大于等于size/2 的
            if (value < size / 2) {
                continue;
            }
            if (value > maxCount) {
                maxCount = value;
                target = entry.getKey();
            }
        }

        if (target != null) {
            // 主要数字存在多个的时候，则认为是不存在
            // 由于题目已经假设主要数字是存在的，所以这里则认为这个是唯一的结果
//            int targetCount = 0;
//            Collection<Integer> values = map.values();
//            for (Integer i : values) {
//                if (maxCount == i) {
//                    targetCount++;
//                }
//
//                // 存在多个数量相同的主要数字
//                if (targetCount > 1) {
//                    return -1;
//                }
//            }

            return target;
        }
        // 没找到
        return -1;
    }

    /**
     * 解法2
     * 1. 取列表的第一个数字，设为x，并记x的数量为1；
     * 2. 向后遍历整个列表，判断数字是否和x相等，如果相等则把数量加1，不想等则减1；
     * 3. 遍历完成后，如果数量大于0，则这个数字是数字；
     * 4. 循环以上过程，最多进行 size/2 + 1 次判断即可；
     *
     * @param nums
     * @return
     */
    private static int solution2(List<Integer> nums) {
        int size = nums.size();
        int step = size / 2 + 1;

        for (int i = 0; i <= step; i++) {
            int x = nums.get(i);
            int count = 1;
            for (int num : nums) {
                if (x == num) {
                    count++;
                } else {
                    count--;
                }
            }

            if (count > 0) {
                return x;
            }
        }

        return -1;
    }

    /**
     * 参考：http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
     * 采用抵消的思想：
     * 1. 把列表的中的数据，可以看作是"主要数"和"非主要数"；
     * 2. 把等量的"主要数"和"非主要数" 相互抵消之后，则可以把他们从列表中去除，后续的列表中的主要数和之前的仍然是一致的；可以认为是等价的列表
     * 3. 从列表的左边开始遍历，如果两个抵消了，那么这两个同时从列表中去除，仍然不影响最终的结果；
     *
     * @param nums
     * @return
     */
    private static int solution3(List<Integer> nums) {
        int candidate = nums.get(0);
        int count = 0;

        for (int num : nums) {
            if (num == candidate) {
                count++;
            } else {
                count--;
            }

            // 如果count==0，则说明，前面所遍历的正好是相等数量的"主要数"和"非主要数"
            // 则完全可以把后续的列表当作是一个新的列表处理就行，前面被"抵消"掉的数据不影响最终结果
            if (count == 0) {
                candidate = num;
                count = 1;
            }
        }

        return candidate;
    }
}
