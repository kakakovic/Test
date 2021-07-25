package com.dsy.leetcode;

public class NO45 {
    public static void main(String[] args) {
        NO45 no45 = new NO45();
        no45.jump(new int[]{2,3,1,1,4});
    }

    public int jump(int[] nums) {
        int count = 0;
        int start = 0;
        int next = nums[0];
        int nextLong = 0;
        int nextStart = 0;
        while (true){
            for (int i = start ; next > 0 ; next--){
                if (i + nums[i] > nextLong){
                    nextLong = nums[i];
                    nextStart = i;
                }
                i++;
                if (i == nums.length - 1){
                    return count;
                }
            }
            next = nextLong;
            start = nextStart;
            count++;
        }
    }
}
