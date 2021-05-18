package com.dsy.leetcode;

public class NO746 {
    public int minCostClimbingStairs(int[] cost) {
        //dp[i]表示从当前台阶出发的最小值
        int[] dp = new int[cost.length];

        if (cost.length == 2){
            return Math.min(cost[0], cost[1]);
        }

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length ; i++){
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
