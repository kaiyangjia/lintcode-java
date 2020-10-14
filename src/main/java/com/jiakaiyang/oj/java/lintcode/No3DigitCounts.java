package com.jiakaiyang.oj.java.lintcode;


/**
 * 3. https://www.lintcode.com/problem/digit-counts/
 * 统计数字
 * <p>
 * 计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。
 * <p>
 * 输入：
 * k = 1, n = 12
 * 输出：
 * 5
 * 解释：
 * 在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] 中，我们发现 1 出现了 5 次 (1, 10, 11, 12)(注意11中有两个1)。
 * Created by jia on 17-4-8.
 */
public class No3DigitCounts {

    // TODO: 18/1/2020 doing
    /**
     * 分析
     * 通过观察可以发现一个规律：
     * 在n=10 的时候，那么会有1个 个位数字是k；
     * 在n=100 的时候，那么会有10个 十位数字是k；
     * 在n=1000 的时候，那么会有100个 百位数字是k；
     * ...
     * 在n=10^m 的时候，那么会有 10^(m - 1)个次高位的数字k；
     * 那么在n=10^m 的时候，总共有 10^1 + 10^2 + 10^3 + ... + 10^(m - 1) 个k
     * 这样就可以计算出 10^m 这样的数字的k的数量。
     * <p>
     * 接下来的思路，就是可以把一个数字n，划分为10的整数次幂部分和其他部分，来依次计算。
     * 比如：50198 = 5 * 10^4 + 0 * 10^3 + 1 * 10^2 + 9 * 10^1 + 8 * 10^0
     * 可以用一个数组存储：[5, 0, 1, 9, 8] （其实就是线性代数）
     *
     * @param k
     * @param n
     * @return
     */
    public static int solution(int k, int n) {
        if (n < k) {
            return 0;
        }

        if (n < 10) {
            return 1;
        }

        int result = 0;
        int i = 0;
        int tmp = n;
        while (tmp > 0) {
            int m = tmp % 10;

            int tmpResult = getMod10Result(i);
            result += m * tmpResult;
            if (m == k) {
                result++;
            }

            tmp /= 10;
            i++;
        }

        return result;
    }

    /**
     * 获取幂是i的是10^i 数字里面包含的k的个数
     * 结果是：10^1 + 10^2 + 10^3 + ... + 10^(m - 1)
     *
     * @param i n对10 的幂
     * @return
     */
    private static int getMod10Result(int i) {
        int result = 0;
        for (int index = i - 1; index > 0; index--) {
            result += 10 ^ index;
        }

        return result;
    }
}
