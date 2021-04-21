package com.dsy.leetcode;

import java.util.Arrays;

public class NO213 {
    public static void main(String[] args) {
        NO213 no213 = new NO213();
        System.out.println(no213.rob(new int[]{1, 2, 1, 1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int[] doubleNums = new int[nums.length * 2];
        for (int i = 0 ; i < nums.length ; i++){
            doubleNums[i] = nums[i];
            doubleNums[i + nums.length] = nums[i];
        }

        //dp[i]表示抢到当前格子时，抢的最大值
        int[] dp = new int[nums.length * 2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2 ; i < doubleNums.length ; i++){
            dp[i] = Math.max(dp[i - 2] + doubleNums[i], dp[i - 1]);
            if (i >= nums.length - 1){
                dp[i] = Math.max(dp[i] - dp[i - nums.length + 1], dp[i - nums.length + 1]);
                //dp[i] -= dp[i - nums.length + 1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : dp){
            max = Math.max(max , num);
        }

        return max;
    }
}
