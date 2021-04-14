package com.dsy.leetcode;

import java.util.List;

public class NO120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        //dp[i][j] 标识到达当前元素的最小路径和
        int[][] dp = new int[n][n];

        dp[0][0] = triangle.get(0).get(0);

        //处理最边上两列
        for (int i = 1 ; i < n ; i++){
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        for (int i = 1 ; i < n ; i++){
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }

        for (int i = 2 ; i < n ; i++){
            for (int j = 1 ; j < i ; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0 ; j < n ; j++){
            min = Math.min(min, dp[n - 1][j]);
        }

        return min;
    }
}
