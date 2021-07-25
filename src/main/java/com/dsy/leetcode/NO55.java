package com.dsy.leetcode;

public class NO55 {
    public static void main(String[] args) {
        NO55 no55 = new NO55();
        no55.canJump(new int[]{3,2,1,0,4});
    }

    public boolean canJump(int[] nums) {
        int longest = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if (i > longest){
                return false;
            }
            longest = Math.max(i + nums[i], longest);
        }
        return true;
    }
}
