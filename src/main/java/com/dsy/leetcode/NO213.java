package com.dsy.leetcode;

import java.util.Arrays;

public class NO213 {
    public static void main(String[] args) {
        NO213 no213 = new NO213();
        System.out.println(no213.rob(new int[]{2, 3, 2}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        //头尾不能同时抢
        return Math.max(robLine(Arrays.copyOf(nums, nums.length - 1)),
            robLine(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int robLine(int[] nums){
        //dp[i]表示到第i个房间能抢到的最大值
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2 ; i <= nums.length ; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }
}
