package com.dsy.leetcode;

public class NO1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        //dp[i][j]表示text1以第i个字符结尾的字符串，与text2以第j个字符结尾的字符串的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1 ; i <= m ; i++){
            for (int j = 1 ; j <= n ; j++){
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
