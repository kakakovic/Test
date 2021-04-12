package com.dsy.leetcode;

public class NO5 {
    public static void main(String[] args) {
        NO5 no5 = new NO5();
        no5.longestPalindrome("abcba");
    }

    public String longestPalindrome(String s) {
        //如果dp的建立不满足最优子结构，证明方式是错误的
        //dp[i][j] 表示s的第i个字符到第j个字符组成的子字符串是否是回文的
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0 ; i < s.length() ; i++){
            dp[i][i] = true;
        }

        //空字符串是回文的
        for (int i = 1 ; i < s.length() ; i++){
            for (int j = 0 ; j < i ; j++){
                dp[i][j] = true;
            }
        }

        for (int i = s.length() - 2 ; i >= 0 ; i--){
            for (int j = i + 1 ; j < s.length() ; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                }else {
                    dp[i][j] = false;
                }
            }
        }

        int max = 1;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0 ; i < s.length() ; i++){
            for (int j = 0 ; j < s.length() ; j++){
                if (dp[i][j]){
                    if (j - i + 1 > max){
                        max = j - i + 1;
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }

        return s.substring(maxI, maxJ + 1);
    }
}
