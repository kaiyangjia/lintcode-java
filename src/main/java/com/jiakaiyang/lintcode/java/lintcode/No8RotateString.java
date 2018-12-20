package com.jiakaiyang.lintcode.java.lintcode;

/**
 * Created by jia on 17-4-8.
 *
 * https://www.lintcode.com/problem/rotate-string/
 *
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * <p>
 * 需要注意的是：该题目要求的是改变输入的源数据
 * <p>
 * <p>
 * 样例
 * 对于字符串 "abcdefg".
 * <p>
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 */
public class No8RotateString {

    /**
     * @param str:    an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public static void rotateString(char[] str, int offset) {
        if (str == null
                || str.length == 0) {
            return;
        }

        if (offset >= str.length) {
            offset = offset % str.length;
        }

        char[] result = new char[str.length];
        int index = str.length - offset;
        for (int i = 0; i < str.length; i++) {
            int j = index % str.length;

            result[i] = str[j];
            index++;
        }


        for (int i = 0; i < str.length; i++){
            str[i] = result[i];
        }
    }
}
