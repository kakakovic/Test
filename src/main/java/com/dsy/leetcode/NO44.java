package com.dsy.leetcode;

public class NO44 {
    public boolean isMatch(String s, String p) {
        int row = s.length();
        int col = p.length();
        boolean[][] dp = new boolean[row + 1][col + 1];

        dp[0][0] = true;
        for (int j = 1 ; j <= col ; j++){
            char c = p.charAt(j - 1);
            if (c == '*' && dp[0][j - 1]){
                dp[0][j] = true;
            }else {
                break;
            }
        }

        for (int i = 1 ; i <= row ; i++){
            for (int j = 1 ; j <= col ; j++){
                char c = p.charAt(j - 1);
                if (c == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (c == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else {
                    dp[i][j] = c == s.charAt(i - 1) && dp[i - 1][j - 1];
                }
            }
        }

        return dp[row][col];
    }
}
