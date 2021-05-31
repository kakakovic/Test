package com.dsy.leetcode;

public class NO300 {
    public int lengthOfLIS(int[] nums) {
        int[] dynamic = new int[nums.length];
        dynamic[0] = 1;
        for (int i = 1 ; i < nums.length ; i++){
            if (nums[i] > nums[i - 1]){
                dynamic[i] = dynamic[i - 1] + 1;
            }else{
                dynamic[i] = dynamic[i - 1];
            }
        }
        return dynamic[nums.length - 1];
    }
}
