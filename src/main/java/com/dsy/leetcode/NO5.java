package com.dsy.leetcode;

public class NO5 {
    public String longestPalindrome(String s) {
        //dp[i][j] 表示s的第i个字符到第j个字符组成的子字符串的回文最大长度
        //i <= j
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0 ; i < s.length() ; i++){
            dp[i][i] = 1;
        }

        for (int i = s.length() - 2 ; i >= 0 ; i--){
            for (int j = i + 1 ; j < s.length() ; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }

        int max = 1;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0 ; i < s.length() ; i++){
            for (int j = 0 ; j < s.length() ; j++){
                if (dp[i][j] > max){
                    max = dp[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        return s.substring(maxI, maxJ + 1);
    }
}
