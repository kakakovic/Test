package com.dsy.leetcode;

public class NO97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()){
            return false;
        }

        //dp[i][j]表示s3中前i+j个元素构成的字符串，是不是由s1以i位置结尾，s2以j位置结尾的两个子字符串构成的交错字符串
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 1 ; i <= s1.length() ; i++){
            dp[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][0];
        }

        for (int j = 1 ; j <= s2.length() ; j++){
            dp[0][j] = s3.charAt(j - 1) == s2.charAt(j - 1) && dp[0][j - 1];
        }

        for (int i = 1 ; i <= s1.length() ; i++){
            for (int j = 1 ; j <= s2.length() ; j++){
                char s3CurrentChar = s3.charAt(i + j - 1);
                boolean s1Go = dp[i - 1][j] && s3CurrentChar == s1.charAt(i - 1);
                boolean s2Go = dp[i][j - 1] && s3CurrentChar == s2.charAt(j - 1);
                dp[i][j] = s1Go || s2Go;
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
