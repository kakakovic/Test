package com.dsy.leetcode;

public class NO45 {
    public static void main(String[] args) {
        NO45 no45 = new NO45();
        System.out.println(no45.jump(new int[]{1,1,1,1}));
    }

    /**
     * 计算每走一步最远能到达的距离
     */
    public int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int count = 0;
        int start = 0;
        int next = nums[0];
        int nextLong = 0;
        int nextStart = 0;
        while (true){
            for (int i = start + 1; next > 0 ; next--){
                if (i >= nums.length - 1){
                    return count + 1;
                }
                if (i + nums[i] > nextLong){
                    nextLong = nums[i] + i;
                    nextStart = i;
                }
                i++;

            }
            next = nextLong - nextStart;
            nextLong = 0;
            start = nextStart;
            count++;
        }
    }
}
