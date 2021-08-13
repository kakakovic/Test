package com.dsy.leetcode;

public class NO42 {
    public static void main(String[] args) {
        NO42 no42 = new NO42();
        System.out.println(no42.trap(new int[]{4,2,0,3,2,5}));
    }

    /**
     * 返回当前元素后最高的元素
     */
    private int[] getMaxHeightAfter(int[] height){
        int[] result = new int[height.length];
        result[height.length - 1] = 0;
        for (int j = height.length - 2 ; j >= 0 ; j--){
            result[j] = Math.max(result[j + 1], height[j + 1]);
        }
        return result;
    }

    /**
     * 返回当前元素前最高的元素
     */
    private int[] getHeightBefore(int[] height){
        int[] result = new int[height.length];
        result[0] = 0;
        for (int i = 1 ; i < height.length ; i++){
            result[i] = Math.max(result[i - 1], height[i - 1]);
        }
        return result;
    }

    public int trap(int[] height) {
        if (height == null || height.length < 3){
            return 0;
        }

        int[] maxHeightAfter = getMaxHeightAfter(height);
        int[] maxHeightBefore = getHeightBefore(height);

        int sum = 0;
        for (int i = 1 ; i < height.length ; i++){
            int before = maxHeightBefore[i];
            int after = maxHeightAfter[i];
            int min = Math.min(before, after);
            if (min > height[i]){
                sum += (min - height[i]);
            }
        }
        return sum;
    }
}
