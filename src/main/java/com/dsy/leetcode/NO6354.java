package com.dsy.leetcode;

public class NO6354 {
    public static void main(String[] args) {
        NO6354 no6354 = new NO6354();
        no6354.findTheArrayConcVal(new int[]{7,52,2,4});
    }

    public long findTheArrayConcVal(int[] nums) {
        if (nums.length == 0){
            return nums[0];
        }
        long sum = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            sum += Long.valueOf(String.valueOf(nums[left]) + String.valueOf(nums[right]));
            left++;
            right--;
        }
        if (left == right){
            sum += nums[left];
        }
        return sum;
    }
}
