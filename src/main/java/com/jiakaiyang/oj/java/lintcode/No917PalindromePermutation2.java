package com.jiakaiyang.oj.java.lintcode;

import java.util.*;

/**
 * https://www.lintcode.com/problem/palindrome-permutation-ii/description
 * <p>
 * 917. 回文排列II
 * <p>
 * 给定一个字符串s，返回所有回文排列(不重复)。如果没有回文排列，则返回空列表。
 * <p>
 * Created by jia on 26/5/2020
 * github: https://github.com/kaiyangjia
 */
public class No917PalindromePermutation2 {

    /**
     * @param s: the given string
     * @return: all the palindromic permutations (without duplicates) of it
     */
    public static List<String> generatePalindromes(String s) {
        // write your code here
        return solution1(s);
    }


    /**
     * 解法1：
     * 1. 先根据 no916 的思路（统计字符的出现次数）来确定是否包含有回文串，有的话进行下一步；
     * 2. 找到"中间点"，如果没有中间点 M 的话，则认为中间点是空字符串；
     * 3. 把找到的出现次数是偶数次的所有字符，数量都除以2之后得到回文单侧需要的字符合集 S；
     * 4. 对S查找它的全排列，同时在找到它的一个全排列结果 PL 后，找到这个结果P的镜像字符串 PR；
     * 5. 由PL+M+PR 组成的结果则为一个合法的回文字符串，上一步中通过回溯找到全排列的同时，就找到了所有的结果；
     *
     * @param s
     * @return
     */
    public static List<String> solution1(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        // 1.1 统计出现的次数
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
            }
        }

        // 1.2 check 是否包含有合法的回文
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        int oddNumber = 0;
        int oddValue = 0;

        // 2. 遍历的同时，找到中间串
        Character middle = null;

        // 3. 遍历的同时，找到回文单侧的字符集合
        List<Character> halfLeft = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : set) {
            int value = entry.getValue();
            Character key = entry.getKey();

            if (value % 2 == 0) {
                // 偶数，把半数的value添加到单侧集合中
                int halfCount = value / 2;
                addChar(halfCount, halfLeft, key);
                continue;
            }

            oddNumber++;
            // 有大于1个奇数，说明没有结果
            if (oddNumber > 1) {
                return result;
            } else if (oddNumber == 1) {
                middle = key;
                oddValue = value;
            }
        }

        // 添加奇数中的数据
        if (oddValue > 1) {
            int halfValue = (oddValue - 1) / 2;
            addChar(halfValue, halfLeft, middle);
        }

        // 4. 回溯获取结果
        int halfTargetLength = halfLeft.size();
        List<Character> track = new ArrayList<>();
        backtrace(result, track, halfLeft, halfTargetLength, middle);
        return result;
    }

    /**
     * 像列表中添加指的数量的字符
     *
     * @param count
     * @param list
     * @param c
     */
    public static void addChar(int count, List<Character> list, Character c) {
        for (int j = 0; j < count; j++) {
            list.add(c);
        }
    }

    /**
     * 回溯算法，获取全排列
     *
     * @param result
     * @param track
     * @param nums
     * @param targetLength
     * @param middle
     */
    public static void backtrace(List<String> result
            , List<Character> track
            , List<Character> nums
            , int targetLength
            , Character middle) {
        if (track.size() == targetLength) {
            // 添加结果
            int arrayLength = middle == null ? targetLength * 2 : targetLength * 2 + 1;
            char[] arr = new char[arrayLength];
            // 添加左边
            for (int i = 0; i < targetLength; i++) {
                arr[i] = track.get(i);
            }

            // 添加中间数
            if (middle != null) {
                arr[targetLength] = middle;
            }

            // 添加右边
            for (int i = 1; i <= targetLength; i++) {
                arr[arrayLength - i] = track.get(i - 1);
            }

            String s = new String(arr);
            result.add(s);
            return;
        }

        // 带有重复的元素，需要把nums 去重，以保证决策树中的子结点是没有重复的
        Set<Character> numsSet = new HashSet<>(nums);
        for (Character c : numsSet) {
            track.add(c);

            // 找到下一层的nums
            LinkedList<Character> nextNums = new LinkedList<>(nums);
            int index = nextNums.indexOf(c);
            nextNums.remove(index);

            backtrace(result, track, nextNums, targetLength, middle);

            track.remove(track.size() - 1);
        }
    }
}
