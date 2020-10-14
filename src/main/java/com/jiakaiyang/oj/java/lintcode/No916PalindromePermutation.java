package com.jiakaiyang.oj.java.lintcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 916. 回文排列
 * <p>
 * https://www.lintcode.com/problem/palindrome-permutation/description
 * <p>
 * 给定一个字符串，判断字符串是否存在一个排列是回文排列
 * <p>
 * Created by jia on 24/5/2020
 * github: https://github.com/kaiyangjia
 */
public class No916PalindromePermutation {

    /**
     * 思路：
     * 回文字符串中的特点是，最多有一个字符，它出现的次数是奇数，其他的出现次数都是偶数
     *
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public static boolean canPermutePalindrome(String s) {
        // write your code here
        return solution(s);
    }

    /**
     * 解法：
     * 1. 统计字符串中出现的所有字符的出现次数
     *
     * @param s
     * @return
     */
    public static boolean solution(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] a = s.toCharArray();

        for (char tmp : a) {
            if (map.containsKey(tmp)) {
                int count = map.get(tmp) + 1;

                map.put(tmp, count);
            } else {
                map.put(tmp, 1);
            }
        }

        int oddNumberCount = 0;
        Collection<Integer> c = map.values();
        for (int i : c) {
            if (i % 2 == 0) {
                continue;
            }

            oddNumberCount++;
            if (oddNumberCount > 1) {
                return false;
            }
        }

        return true;
    }
}
