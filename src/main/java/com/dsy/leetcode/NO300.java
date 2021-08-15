package com.dsy.leetcode;

public class NO300 {
    public static void main(String[] args) {
        NO300 no300 = new NO300();
        System.out.println(no300.lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }

    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] maxLast = getMaxWithLast(nums);
        for (int x : maxLast){
            max = Math.max(max, x);
        }
        return max;
    }

    /**
     * 计算以第i个元素结尾的字符串的最大递增长度
     */
    private int[] getMaxWithLast(int[] nums){
        int[] dynamic = new int[nums.length];
        dynamic[0] = 1;
        for (int i = 1 ; i < nums.length ; i++){
            dynamic[i] = 1;
            for (int j = 0 ; j < i ; j++){
                if (nums[i] > nums[j]){
                    dynamic[i] = Math.max(dynamic[i], dynamic[j] + 1);
                }
            }
        }
        return dynamic;
    }
}
