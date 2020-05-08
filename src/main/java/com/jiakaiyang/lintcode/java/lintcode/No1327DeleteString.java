package com.jiakaiyang.lintcode.java.lintcode;

/**
 * 1327. 删除字符
 * <p>
 * https://www.lintcode.com/problem/delete-string/description
 * <p>
 * 给定一个字符串，要求去掉一个字符，使得剩下的两个字符串按顺序拼接在一起，使得最后得到的字符串字典序最小。返回这个字符串。
 * <p>
 * 样例
 * 例 1:
 * <p>
 * 输入:"acd"
 * 输出:"ac"
 * 解释:"ac"是字典序最小的
 * 例 2:
 * <p>
 * 输入:"ozwdtvxuhx"
 * 输出:"owdtvxuhx"
 * <p>
 * Created by jia on 8/5/2020
 * github: https://github.com/kaiyangjia
 */
public class No1327DeleteString {

    /**
     * 思路：
     * 把字符串从前到后进行遍历
     * a. 当发现有降序排列的时候，就把高位的那个删除掉；
     * b. 如果始终没有发现降序的排列，就把最后那一位删除掉；
     *
     * @param str: the str
     * @return: the delete positon
     */
    public String deleteString(String str) {
        // Write your code here.
        if (str == null || str.length() <= 1) {
            return str;
        }

        int length = str.length();
        int index = 0;

        while (index < length - 1) {
            char a = str.charAt(index);
            char b = str.charAt(index + 1);

            if (a > b) {
                String result = str.substring(0, index) + str.substring(index + 1);
                return result;
            }

            index++;
        }

        return str.substring(0, length - 1);
    }
}
