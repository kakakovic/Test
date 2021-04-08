package com.dsy.leetcode;

public class NO70 {
    public static void main(String[] args) {
        NO70 no70 = new NO70();
        no70.climbStairs(4);
    }

    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        //dp[i]表示n为i时，有多少种可能
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3 ; i <= n ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
