package com.jiakaiyang.oj.java.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.lintcode.com/problem/valid-palindrome/description
 * 415. 有效回文串
 * <p>
 * 给定一个字符串，判断其是否为一个回文串。只考虑字母和数字，忽略大小写。
 * <p>
 * 空字符串定义为是回文串
 * Created by jia on 27/5/2020
 * github: https://github.com/kaiyangjia
 */
public class No415ValidPalindrome {

    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public static boolean isPalindrome(String s) {
        // write your code here
        return solution1(s);
    }

    public static boolean solution1(String s) {
        if (s == null) {
            // 认为空串是回文
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        List<Character> arr = filter(s.toCharArray());

        int leftIndex = 0;
        int rightIndex = arr.size() - 1;

        while (leftIndex < rightIndex) {
            char left = Character.toLowerCase(arr.get(leftIndex));
            char right = Character.toLowerCase(arr.get(rightIndex));
            if (left != right) {
                return false;
            }

            leftIndex++;
            rightIndex--;
        }

        return true;
    }

    /**
     * 过滤掉非法的字符串
     *
     * @param arr
     * @return
     */
    public static List<Character> filter(char[] arr) {
        List<Character> list = new ArrayList<>();
        for (char c : arr) {
            if (validChar(c)) {
                list.add(c);
            }
        }
        return list;
    }

    /**
     * 判断是否为合法的元素，字母和数字为合法的
     *
     * @param c
     * @return
     */
    public static boolean validChar(char c) {
        boolean number = c >= '0' && c <= '9';
        boolean lowerCase = c >= 'a' && c <= 'z';
        boolean upperCase = c >= 'A' && c <= 'Z';

        return number || lowerCase || upperCase;
    }
}
