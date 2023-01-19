package com.dsy.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NO4 {
    public static void main(String[] args) {
        NO4 no4 = new NO4();
        double result = no4.findMedianSortedArrays(new int[]{3}, new int[]{-2,-1});
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthOne = nums1.length;
        int lengthTwo = nums2.length;
        if ((lengthOne + lengthTwo) % 2 == 0){
            double first = findKthMinElement(nums1, nums2, (lengthOne + lengthTwo) / 2) * 0.5;
            double second = findKthMinElement(nums1, nums2, (lengthOne + lengthTwo) / 2 + 1) * 0.5;
            return first + second;

        }else {
            return findKthMinElement(nums1, nums2, (lengthOne + lengthTwo) / 2 + 1);
        }
    }

    private int findKthMinElement(int[] nums1, int[] nums2, int k){
        if (nums1.length == 0){
            return nums2[k - 1];
        }
        if (nums2.length == 0){
            return nums1[k - 1];
        }
        if (k == 1){
            return Math.min(nums1[0], nums2[0]);
        }

        int step = Math.min(k / 2, Math.min(nums1.length, nums2.length));
        int num1 = nums1[step - 1];
        int num2 = nums2[step - 1];

        if (num1 <= num2){
            int[] nums11 = Arrays.copyOfRange(nums1, step, nums1.length);
            return findKthMinElement(nums11, nums2, k - step);
        }else {
            int[] nums22 = Arrays.copyOfRange(nums2, step, nums2.length);
            return findKthMinElement(nums1, nums22, k - step);
        }
    }
}
