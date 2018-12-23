package com.jiakaiyang.lintcode.java.lintcode;


/**
 * 49. 字符大小写排序
 * <p>
 * https://www.lintcode.com/problem/sort-letters-by-case/description
 */
public class No49SortLettersByCase {

    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here
        MySolution.sortLetters(chars);
    }

    /**
     * 使用快速排序的交换思路，把大写交换到右侧，小写交换到左侧
     */
    public static class MySolution {

        public static void sortLetters(char[] chars) {
            // write your code here
            sortLetters(chars, 0, chars.length - 1);
        }

        public static void sortLetters(char[] chars, int start, int end) {
            if (chars == null || start >= end
                    || start < 0
                    || end >= chars.length) {

                return;
            }

            while (start < end) {
                while (start < end
                        && Character.isLowerCase(chars[start])) {
                    start++;
                }

                while (start < end
                        && Character.isUpperCase(chars[end])) {
                    end--;
                }

                if (start < end) {
                    char tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;
                }
            }
        }
    }
}
