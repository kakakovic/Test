package com.dsy.leetcode;

public class NO392 {
    public static void main(String[] args) {
        NO392 no392 = new NO392();
        no392.isSubsequence("", "ahbgdc");
    }

    public boolean isSubsequence(String s, String t) {
        //dp[i][j]表示s中前个元素组成的子字符串是不是t中前j个元素组成的子字符串
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];

        for (int j = 0 ; j <= t.length() ; j++){
            dp[0][j] = true;
        }

        for (int i = 1 ; i <= s.length() ; i++){
            for (int j = 1 ; j <= t.length() ; j++){
                if (dp[i][j - 1]){
                    dp[i][j] = true;
                }else {
                    if (!dp[i - 1][j - 1] || !dp[i - 1][j]){
                        dp[i][j] = false;
                    }else {
                        if (s.charAt(i - 1) == t.charAt(j - 1)){
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
