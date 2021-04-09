package com.dsy.leetcode;

/**
 * 弱智题目
 */
public class NO63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1){
            return 0;
        }

        //dp[i][j]表示到达当前位置时，总共有多少路径
        //0表示不可达
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 1 ; i < m ; i++){
            if (obstacleGrid[i][0] != 1 && dp[i - 1][0] != 0){
                dp[i][0] = 1;
            }else {
                dp[i][0] = 0;
            }
        }

        for (int j = 1 ; j < n ; j++){
            if (obstacleGrid[0][j] != 1 && dp[0][j - 1] != 0){
                dp[0][j] = 1;
            }else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1 ; i < m ; i++){
            for (int j = 1 ; j < n ; j++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    if (dp[i - 1][j] != 0 && dp[i][j - 1] != 0){
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }else if (dp[i - 1][j] == 0 && dp[i][j - 1] == 0){
                        dp[i][j] = 0;
                    }else if (dp[i - 1][j] == 0){
                        dp[i][j] = dp[i][j - 1];
                    }else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }
}
