package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO279 {
    public static void main(String[] args) {
        NO279 no279 = new NO279();
        no279.numSquares(12);
    }

    public int numSquares(int n) {
        //dp[i]表示n为i时，最少能有几个完全平方数相加得到
        int[] dp = new int[n + 1];
        List<Integer> allNumber = getNumber(n);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2 ; i <= n ; i++){
            int current = Integer.MAX_VALUE;
            for (int num : allNumber){
                if (num <= i){
                    current = Math.min(current, dp[i - num] + 1);
                }else {
                    break;
                }
            }
            dp[i] = current;
        }
        return dp[n];
    }

    /**
     * 返回小于n的完全平方数
     */
    private List<Integer> getNumber(int n){
        List<Integer> result = new ArrayList<>();
        for (int i = 1 ; i <= 100 ; i++){
            if (i * i <= n){
                result.add(i * i);
            }else {
                break;
            }
        }
        return result;
    }
}
