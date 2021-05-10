package com.dsy.leetcode;

public class NO1025 {
    public static void main(String[] args) {
        NO1025 no1025 = new NO1025();
        no1025.divisorGame(3);
    }

    public boolean divisorGame(int n) {
        if (n <= 2){
            return true;
        }
        //第一行表示爱丽丝先手时能否取胜
        //第二行表示爱丽丝后手时能否取胜
        boolean[][] dp = new boolean[2][n];

        dp[0][0] = true;
        dp[0][1] = true;

        for (int i = 2 ; i < n ; i++){
            for (int num = 1 ; num < i + 1 ; num++){
                if ((i + 1) % num != 0){
                    continue;
                }
                if (dp[1][i - num]){
                    dp[0][i] = true;
                    dp[1][i] = false;
                    break;
                }
                dp[1][i] = true;
            }
        }

        return dp[0][n - 1];
    }
}
