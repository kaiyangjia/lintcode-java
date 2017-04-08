package com.jiakaiyang.lintcode.java;

import java.math.BigInteger;

/**
 * Created by jia on 17-4-8.
 * 计算Fibonacci数列的第n项值
 * <p>
 * 查找斐波纳契数列中第 N 个数。
 * <p>
 * 所谓的斐波纳契数列是指：
 * 前2个数是 0 和 1 。
 * 第 i 个数是第 i-1 个数和第i-2 个数的和。
 * 斐波纳契数列的前10个数字是：
 * <p>
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 */
public class Fibonacci {

    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public static int fibonacci(int n) {
        // write your code here

        if (n <= 0) {
            return -1;
        }

        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        BigInteger zero = new BigInteger("0");

        BigInteger n1 = new BigInteger("0");
        BigInteger n2 = new BigInteger("1");
        BigInteger result = new BigInteger("0");

        for (int i = 3; i <= n; i++) {
            result = n1.add(n2);

            n1 = n2.add(zero);
            n2 = result.add(zero);
        }

        return result.intValue();
    }
}
