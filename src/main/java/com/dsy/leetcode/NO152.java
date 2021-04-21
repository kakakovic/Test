package com.dsy.leetcode;

public class NO152 {
    public static void main(String[] args) {
        NO152 no152 = new NO152();
        no152.maxProduct(new int[]{-2,0,1});
    }

    public int maxProduct(int[] nums) {
        //第j列表示处理到nums中第j个元素时，第一行是最大值，第二行是最小值
        int[][] dp = new int[2][nums.length];

        dp[0][0] = nums[0];
        dp[1][0] = nums[0];

        for (int j = 1 ; j < nums.length ; j++){
            if (nums[j] == 0){
                dp[0][j] = 0;
                dp[1][j] = 0;
            }else if (nums[j] > 0){
                if (dp[0][j - 1] <= 0){
                    dp[0][j] = nums[j];
                }else{
                    dp[0][j] = nums[j] * dp[0][j - 1];
                }

                if (dp[1][j - 1] > 0 ){
                    dp[1][j] = nums[j];
                }else {
                    dp[1][j] = dp[1][j - 1] * nums[j];
                }
            }else {
                if (dp[1][j - 1] <= 0){
                    dp[0][j] = dp[1][j - 1] * nums[j];
                }else {
                    dp[0][j] = nums[j];
                }

                if (dp[0][j - 1] > 0){
                    dp[1][j] = dp[0][j - 1] * nums[j];
                }else {
                    dp[1][j] = nums[j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : dp[0]){
            max = Math.max(max, num);
        }
        return max;
    }
}
