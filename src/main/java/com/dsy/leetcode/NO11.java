package com.dsy.leetcode;

public class NO11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right){
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, minHeight * (right - left));
            //以较矮高度作为边界，能围出的最大元素已经计算得出了，可以抛弃最小高度了
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
