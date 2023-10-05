package com.dsy.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class NO239 {
    public static void main(String[] args) {
        NO239 no239 = new NO239();
        no239.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1){
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);
        for (int i = 1 ; i < nums.length ; i++){
            if (i >= k){
                int firstIndex = deque.peekFirst();
                if (firstIndex < i - k + 1){
                    deque.removeFirst();
                }
            }

            int lastIndex = deque.peekLast();
            while (nums[i] >= nums[lastIndex]){
                deque.removeLast();
                if (deque.isEmpty()){
                    break;
                }
                lastIndex = deque.getLast();
            }
            deque.offer(i);

            if (i >= k - 1){
                int firstIndex = deque.peekFirst();
                result[i - k + 1] = nums[firstIndex];
            }
        }
        return result;
    }
}
