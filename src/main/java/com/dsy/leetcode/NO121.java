package com.dsy.leetcode;

public class NO121 {
    public int maxProfit(int[] prices) {
        //dp[i]表示在当前时刻遇到过的买入价的最小值
        int[] dp = new int[prices.length];

        dp[0] = prices[0];
        for (int i = 1 ; i < dp.length ; i++){
            dp[i] = Math.min(prices[i], dp[i - 1]);
        }

        int max = 0;
        for (int i = 0 ; i < prices.length ; i++){
            max = Math.max(max, prices[i] - dp[i]);
        }

        return max;
    }
}
