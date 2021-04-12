package com.dsy.leetcode;

public class NO53 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;

        //dp[i]表示以当前元素为结尾的最大连续子数组的和
        int dp[] = new int[length];

        dp[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            dp[i] = dp[i - 1] <= 0 ? nums[i] : dp[i - 1] + nums[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < nums.length ; i++){
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
