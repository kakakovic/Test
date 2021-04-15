package com.dsy.leetcode;

public class NO198 {
    public int rob(int[] nums) {
        //dp[i]表示以当前这个房子为结尾时，最大的偷取金额
        int[] dp = new int[nums.length + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2 ; i < dp.length ; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[nums.length];
    }
}
