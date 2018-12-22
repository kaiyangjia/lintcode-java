package com.jiakaiyang.lintcode.java.lintcode;

/**
 * Created by jia on 2017/8/27.
 * 寻找丑数算法
 * <p>
 * https://www.lintcode.com/problem/ugly-number-ii/description
 * <p>
 * 参考博客：http://zhedahht.blog.163.com/blog/static/2541117420094245366965/
 */
public class No4UglyNumber2 {

    /**
     * @param n
     * @return
     */
    public static int getUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        long[] uglyNumbers = new long[n];

        int currentMaxIndex = 0;
        long currentMax = uglyNumbers[0] = 1;

        /**
         * 在列表中会存在这么一个位置n，它的前面的数字乘以2的结果比当前列表中的最大值要小，记在该处的数字为T2
         *
         * 同样，也会存在类似的数字T3， T5。
         *
         * 在循环的过程中保存下这三个数字，将会把计算的次数减少很多。
         */

        int t2 = 0, t3 = 0, t5 = 0;

        while (currentMaxIndex < n - 1) {
            long nextNumber = Long.MAX_VALUE;

            //找到下一个丑数
            for (int j = t5; j <= currentMaxIndex; j++) {
                long i = uglyNumbers[j];

                // TODO: 2017/8/27 根据t3 和 t5 的值进行计算
                long i2 = i * 2;
                long i3 = i * 3;
                long i5 = i * 5;

                i2 = (i2 > currentMax) ? i2 : Long.MAX_VALUE;
                i3 = (i3 > currentMax) ? i3 : Long.MAX_VALUE;
                i5 = (i5 > currentMax) ? i5 : Long.MAX_VALUE;

                long newMin = min(i2, i3, i5);
                nextNumber = Math.min(newMin, nextNumber);
            }

            currentMaxIndex++;
            currentMax = nextNumber;
            uglyNumbers[currentMaxIndex] = currentMax;

            while ((uglyNumbers[t2] * 2) <= currentMax) {
                t2++;
            }

            while ((uglyNumbers[t2] * 3) <= currentMax) {
                t3++;
            }

            while ((uglyNumbers[t2] * 5) <= currentMax) {
                t5++;
            }
        }

        return (int) uglyNumbers[n - 1];
    }

    public static long min(long i1, long i2, long i3) {
        long min = Math.min(i1, i2);
        return Math.min(min, i3);
    }
}
