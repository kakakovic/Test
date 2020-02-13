package com.dsy.leetcode;

public class NO1326 {
    public int minTaps(int n, int[] ranges) {
        int[] max_range = new int[n + 1];

        for (int i = 0 ; i < ranges.length ; i++){
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n , i + ranges[i]);
            max_range[left] = right;
        }

        int end = 0;
        int next = 0;
        int step = 0;

        for(int i = 0 ; i <= end ; ++i){
            next = Math.max(next, max_range[i]);
            if(i == end){
                end = next;
                step++;
                if(end >= n) return step;
            }
        }
        return -1;
    }
}
