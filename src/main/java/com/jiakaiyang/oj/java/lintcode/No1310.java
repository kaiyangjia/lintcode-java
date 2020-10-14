package com.jiakaiyang.oj.java.lintcode;

/**
 * 1310. 数组除了自身的乘积
 * https://www.lintcode.com/problem/product-of-array-except-self/description
 * <p>
 * 给定n个整数的数组nums，其中n> 1，返回一个数组输出，使得output [i]等于nums的所有除了nums [i]的元素的乘积。
 * 在没有除和O(n)时间内解决
 * <p>
 * Created by jia on 9/2/2020
 * github: https://github.com/kaiyangjia
 */
public class No1310 {

    /**
     * 分析：
     * [0, 1, 2, 3, 4, 5]
     * <p>
     * 两个辅助数组
     * s = [1, s1, s2, s3, s4, s5]
     * r = [r5, r4, r3, r2, r1, 1]
     * <p>
     * 其中：
     * - sn表示：从数组的左侧开始，向右前n个数字的乘积；
     * - rn表示：从数组的右侧开始，像左的前n个数字的乘积；
     * <p>
     * 那么，可以看出，最终结果的数组result[n] = s[n] * r[n]
     * 其中，s和r两个数组中的1是为了补位，方便计算
     *
     * @param nums: an array of integers
     * @return: the product of all the elements of nums except nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        // write your code here
        if (nums == null) {
            return null;
        }
        int length = nums.length;
        if (length == 0) {
            // 空数组处理
            return nums;
        }

        // 声明两个辅助数组，都是和源数组等长
        int[] s = new int[length], r = new int[length];

        // 补位
        s[0] = 1;
        r[length - 1] = 1;

        int tmp = nums[0];
        int tmpR = nums[length - 1];

        for (int i = 1; i < length; i++) {
            s[i] = tmp;
            r[length - 1 - i] = tmpR;

            tmp *= nums[i];
            tmpR *= nums[length - 1 - i];
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = s[i] * r[i];
        }

        return result;
    }
}
