package com.jiakaiyang.lintcode.java.lintcode;

import java.util.*;

/**
 * Created by jia on 17-4-8.
 * https://www.lintcode.com/problem/valid-sudoku/description
 *
 * <p>
 * 请判定一个数独是否有效。
 * <p>
 * 该数独可能只填充了部分数字，其中缺少的数字用 . 表示。
 * <p>
 * 注意事项
 * 一个合法的数独（仅部分填充）并不一定是可解的。我们仅需使填充的空格有效即可。
 */
public class No389IsValidSudoku {

    /**
     * TODO 测试不通过
     * @param board: the board
     * @return: wether the Sudoku is valid
     */
    public static boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        if (board.length != board[0].length) {
            return false;
        }

        Map<String, char[][]> cells = new HashMap<String, char[][]>();

        int size = board.length;
        int childSize = size / 3;

        if (childSize < 3) {
            return true;
        }

        for (int i = 0; i < size; i++) {
            //判断每行
            if (!isLegal(board[i])) {
                return false;
            }

            //判断列
            char[] column = new char[size];
            for (int j = 0; j < size; j++) {
                column[j] = board[j][i];


                String key = i / childSize + "," + j / childSize;
                char[][] cell;
                if (cells.containsKey(key)) {
                    cell = cells.get(key);
                } else {
                    cell = new char[childSize][childSize];
                }

                cell[i % childSize][j % childSize] = board[i][j];
            }
            if (!isLegal(column)) {
                return false;
            }
        }

        //判断每个cell
        for (char[][] cell : cells.values()) {
            if (!isValidSudoku(cell)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断一个数组中是否有相同的字符
     *
     * @param src
     * @return
     */
    public static boolean isLegal(char[] src) {
        if (src == null
                || src.length == 0) {
            return false;
        }

        int charCount = 0;

        //利用集合去除重复元素
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < src.length; i++) {
            char c = src[i];
            if (c > 9) {
                return false;
            }

            if ('.' != c) {
                set.add(c);
                charCount++;
            }
        }

        return set.size() == charCount;
    }
}
