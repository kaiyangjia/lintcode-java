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
     *
     * @param board: the board
     * @return: wether the Sudoku is valid
     */
    public static boolean isValidSudoku(char[][] board) {
        return solution1(board);
    }


    public static boolean solution2(char[][] board) {
        // process row
        for (int i = 0; i < 9; i++) {
            boolean[] visited = new boolean[9];

            for (int j = 0; j < 9; j++) {
                boolean result = isLegal(visited, board[i][j]);
                if (!result) {
                    return false;
                }
            }
        }

        // process column
        for (int i = 0; i < 9; i++) {
            boolean[] visited = new boolean[9];

            for (int j = 0; j < 9; j++) {
                boolean result = isLegal(visited, board[j][i]);
                if (!result) {
                    return false;
                }
            }
        }

        // process sub matrix
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                boolean[] visited = new boolean[9];

                for (int k = 0; k < 9; k++) {
                    boolean result = isLegal(visited, board[i + k / 3][j + k%3]);
                    if (!result) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    /**
     * 判断一个新的 char 是否合法
     *
     * @param visited 存储一个新的字符是否已经存在了，数组的下标是数独格里面的值
     * @param newOne  新的一个数独单元格里面的值
     * @return true，新的 char 在当前的状态是合法的，否则就是 false
     */
    public static boolean isLegal(boolean[] visited, char newOne) {
        if (newOne == '.') {
            return true;
        }

        // 转换成int
        int num = newOne - '0';
        if (num < 1 || num > 9) {
            return false;
        }

        // 已经存在
        if (visited[num - 1]) {
            return false;
        }

        visited[num - 1] = true;
        return true;
    }

    /**
     * 我的思路，fail
     *
     * @param board
     * @return
     */
    public static boolean solution1(char[][] board) {
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
