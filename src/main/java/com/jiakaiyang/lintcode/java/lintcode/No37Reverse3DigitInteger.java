package com.jiakaiyang.lintcode.java.lintcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 37. 反转一个3位整数
 * <p>
 * https://www.lintcode.com/problem/reverse-3-digit-integer/description
 * <p>
 * <p>
 * 描述
 * <p>
 * 反转一个只有3位数的整数。
 * <p>
 * 你可以假设输入一定是一个只有三位数的整数，这个整数大于等于100，小于1000。
 * <p>
 * <p>
 * 样例
 * <p>
 * 123 反转之后是 321。
 * 900 反转之后是 9。
 */
public class No37Reverse3DigitInteger {

    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        // write your code here

        return MySolution.reverseInteger(number);
    }


    /**
     * 我的解题方法
     * 1. 从后向前把原int的每一位存放在List里；
     * 2. 只要在遇到第一个不为0的时候才开始存放
     * 3. 把上一步得到的list从前向后转成一个int
     */
    public static class MySolution {

        public static int reverseInteger(int number) {
            boolean resultHighNumber = false;

            List<Integer> resultList = new ArrayList<>();
            int i = number;
            while (i != 0) {
                int remainder = i % 10;

                if (!resultHighNumber && remainder != 0) {
                    resultHighNumber = true;
                }

                i /= 10;
                if (!resultHighNumber) {
                    continue;
                }

                resultList.add(remainder);
            }


            return mergeToInt(resultList);
        }


        /**
         * Merge int list to a int
         *
         * @param list
         * @return
         */
        public static int mergeToInt(List<Integer> list) {
            int resultSize = list.size();

            int result = 0;
            for (int j = 0; j < resultSize; j++) {
                int num = list.get(j);
                result += Math.pow(10, resultSize - j - 1) * num;
            }

            return result;
        }
    }
}
