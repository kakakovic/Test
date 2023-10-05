package com.dsy.leetcode;

import java.util.Arrays;

public class NO6355 {
    public static void main(String[] args) {
        NO6355 no6355 = new NO6355();

        no6355.countFairPairs(new int[]{-5,-7,-5,-7,-5}, -12, -12);
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] > upper && nums[i] > 0){
                continue;
            }
            for (int j = i + 1 ; j < nums.length ; j++){
                int sum = nums[i] + nums[j];
                if (sum >= lower && sum <= upper){
                    count++;
                }else if (sum > upper && sum > 0){
                    break;
                }
            }
        }
        return count;
    }
}
