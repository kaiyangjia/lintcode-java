package com.jiakaiyang.oj.java.leetcode;

public class No59SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int left = 0, top = 0, right = n - 1, bottom = n - 1;
        int current = 1;
        int target = n * n;

        while (current <= target) {
            for (int i = left; i <= right; i++) {
                arr[top][i] = current++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                arr[i][right] = current++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                arr[bottom][i] = current++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                arr[i][left] = current++;
            }
            left++;
        }

        return arr;
    }
}
