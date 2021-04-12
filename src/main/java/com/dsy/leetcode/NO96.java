package com.dsy.leetcode;

public class NO96 {
    /**
     * dp[i]表示由连续i个递增的元素组成的二叉搜索树有多少种
     */
    private int[] dp = new int[20];

    public static void main(String[] args) {
        NO96 no96 = new NO96();
        System.out.println(no96.numTrees(4));
    }

    /**
     * @param n n最大为20
     */
    public int numTrees(int n) {
        if (n <= 1){
            return 1;
        }

        int result = 0;
        for (int i = 1 ; i <= n ; i++){
            int before = dp[i - 1] > 0 ? dp[i - 1] : numTrees(i - 1);
            int after = dp[n - i] > 0 ? dp[n - i] : numTrees(n - i);
            result += before * after;
        }

        dp[n] = result;
        return dp[n];
    }
}
