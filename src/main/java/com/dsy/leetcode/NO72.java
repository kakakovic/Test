package com.dsy.leetcode;

public class NO72 {
    public static void main(String[] args) {
        NO72 no72 = new NO72();
        System.out.println(no72.minDistance("horse", "ros"));
    }

    /**
     * 自顶向下、自底向上均可
     */
    public int minDistance(String word1, String word2) {
        //dp[i][j]表示word1的前i个元素变成word2的前j个元素的编辑距离
        //作为特例要考虑word1、word2为空的情况
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int j = 0 ; j <= word2.length() ; j++){
            dp[0][j] = j;
        }

        for (int i = 0 ; i <= word1.length() ; i++){
            dp[i][0] = i;
        }

        for (int i = 1 ; i <= word1.length() ; i++){
            for (int j = 1 ; j <= word2.length() ; j++){
                int add = dp[i - 1][j] + 1;
                int delete = dp[i][j - 1] + 1;
                //+优先级高于==
                int modifyIfNeed = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);

                int min = Math.min(add, delete);
                min = Math.min(modifyIfNeed, min);

                dp[i][j] = min;
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
