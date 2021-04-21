package com.dsy.leetcode;

public class NO122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0 ; i < prices.length - 1 ; i++){
            if (prices[i + 1] > prices[i]){
                //贪心的抓住所有股价上升的机会
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }
}
