package com.jiakaiyang.oj.java.lintcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jia on 17-4-8.
 * https://www.lintcode.com/problem/trailing-zeros/
 *
 * 2. 尾部的零
 *
 * 设计一个算法，计算出n阶乘中尾部零的个数
 *
    思路1：N！=K x 10^M，且K不能被10整除，那么N！末尾有M个0.
    思路2：进行因数分解，N！=（2^x）x（3^y）x（5^z）...,
    由于10=2x5，所以0的个数M只跟x和z有关，且M=min(x,z)，
    因为能被2整除的数出现的频率比能被5整除的数高得多，所以x>z，所以M=z。
    参考原文：http://blog.csdn.net/fjx1173865548/article/details/47281001

 基本方法：求出n的阶乘，然后转成字符串判断末尾的0的个数
 */
public class No2TrailingZeros {

    /**
     * 根据思路2求解
     * @param n
     * @return
     */
    public static long getResult2(BigInteger n) {
        if (n.signum() == 0
                || n.signum() == -1) {
            return 0;
        }

        BigInteger count = new BigInteger("0");
        BigInteger one = new BigInteger("1");
        BigInteger five = new BigInteger("5");

        while (n.compareTo(one) == 1) {
            count = count.add(n.divide(five));
            n = n.divide(five);
        }

        return count.longValue();
    }


    /**
     * 基本方法，先算阶乘再判断，时间复杂度太高，无法通过测试
     * @param n
     * @return
     */
    public static long getResultBasic(long n){
        BigInteger fact = factorial(n);
        String strFact = fact.toString();
        System.out.println("strFact: " + strFact);

        long count = 0;
        if (strFact != null) {
            byte[] chars = strFact.getBytes();
            for (int i = chars.length - 1;i>=0;i--) {
                //48是0对应的值
                if (chars[i] == 48) {
                    count ++;
                }else {
                    //有一个不是就跳出循环
                    break;
                }
            }
        }
        return count;
    }


    /**
     * for循环计算阶乘
     * @param n
     * @return
     */
    public static BigInteger factorial(long n){
        BigInteger fact = new BigInteger("1");
        for (int i=2;i<=n;i++) {
            fact = fact.multiply(new BigInteger(String.valueOf(i)));
        }

        return fact;
    }

    /**
     * 因式分解
     * @param n
     * @return
     */
    public static List<Long> factoring(long n){
        if (n == 2L) {
            List<Long> result = new ArrayList<Long>();
            result.add(2L);
            return result;
        }

        List<Long> result = new ArrayList<Long>();
        for (long i=2L;i * i <= n;) {
            if (n % i == 0) {
                result.add(i);

                n /= i;
            }else {
                i ++;
            }
        }

        return result;
    }
}
