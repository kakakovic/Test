package com.dsy.leetcode;

public class NO221 {
    public int maximalSquare(char[][] matrix) {
        //dp[i][j]表示以matrix[i][j]元素为右下角的正方形的最大边长
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1 ; i <= matrix.length ; i++){
            for (int j = 1; j <= matrix[0].length ; j++){
                if (matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1 ; i <= matrix.length ; i++){
            for (int j = 1; j <= matrix[0].length ; j++){
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}
