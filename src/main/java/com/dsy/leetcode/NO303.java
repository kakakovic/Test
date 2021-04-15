package com.dsy.leetcode;

public class NO303 {
    class NumArray {
        /**
         * dp[i]表示从0到第i个元素结尾的累加和
         */
        private int[] dp;

        public NumArray(int[] nums) {
            dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length ; i++){
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0){
                return dp[right];
            }else {
                return dp[right] - dp[left - 1];
            }
        }
    }
}
