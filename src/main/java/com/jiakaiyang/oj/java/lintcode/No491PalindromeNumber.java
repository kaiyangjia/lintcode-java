package com.jiakaiyang.oj.java.lintcode;

/**
 * 491. 回文数
 * https://www.lintcode.com/problem/palindrome-number/description
 * <p>
 * 判断一个正整数是不是回文数。
 * <p>
 * 回文数的定义是，将这个数反转之后，得到的数仍然是同一个数。
 * <p>
 * Created by jia on 29/5/2020
 * github: https://github.com/kaiyangjia
 */
public class No491PalindromeNumber {
    final static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE};

    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public static boolean isPalindrome(int num) {
        // write your code here
        return solution1(num);
    }

    /**
     * 1. 获取当前数字为位数 size
     * 2. 遍历 size/2 次，分别用两个指针从高位和低位同时像中间遍历，获取每一对最高位和最低位的数值h 和 l
     * 3. 如果出现 h 和 l不相等的情况，则说明不是回文数字；
     * 4. 否则则为回文数字
     *
     * @param num
     * @return
     */
    public static boolean solution1(int num) {
        if (num < 10) {
            return true;
        }
        int size = sizeOf(num);
        int half = size / 2;

        int highNum = num, lowNum = num;

        for (int i = 0; i < half; i++) {
            int h = getHighNum(highNum, size - i);
            int l = getLowNum(lowNum);

            if (h != l) {
                return false;
            }

            // 用于计算高位的下一个
            highNum -= h * (int) Math.pow(10, size - i - 1);
            lowNum /= 10;
        }

        return true;
    }

    /**
     * 获取最高位的数值
     *
     * @param num
     * @return
     */
    public static int getHighNum(int num, int size) {
        int i = (int) Math.pow(10, size - 1);

        int result = num / i;
        return result;
    }

    /**
     * 获取最低位的数值
     *
     * @param num
     * @return
     */
    public static int getLowNum(int num) {
        return num % 10;
    }

    /**
     * 获取 int 的位数
     *
     * @param num
     * @return
     */
    public static int sizeOf(int num) {
        for (int i = 0; ; i++) {
            if (num <= sizeTable[i]) {

                return i + 1;
            }
        }
    }
}
