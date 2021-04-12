package com.dsy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NO474 {
    public static void main(String[] args) {
        NO474 no474 = new NO474();
        System.out.println(no474.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5,3));
    }

    private Map<String, int[]> cache = new HashMap<>();

    private int[] calculate(String str) {
        if (cache.containsKey(str)){
            return cache.get(str);
        }else {
            int[] res = new int[2];
            Arrays.fill(res, 0);

            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    res[0]++;
                } else if (ch == '1') {
                    res[1]++;
                }
            }
            cache.put(str, res);
            return res;
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j][k] 表示遇到第i个元素时，还有j个0，k个1，最多能有几个元素
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        //无需特殊考虑0个0和0个1的情况
        for (int i = 1 ; i <= strs.length ; i++){
            for (int j = 0 ; j <= m ; j++){
                for (int k = 0 ; k <= n ; k++){
                    int[] nums = calculate(strs[i - 1]);
                    int countZero = nums[0];
                    int countOne = nums[1];
                    if (countZero <= j && countOne <= k){
                        dp[i][j][k] = Math.max(dp[i - 1][j - countZero][k - countOne] + 1, dp[i - 1][j][k]);
                    }else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }
}
