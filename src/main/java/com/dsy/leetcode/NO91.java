package com.dsy.leetcode;

public class NO91 {
    public static void main(String[] args) {
        NO91 no91 = new NO91();
        no91.numDecodings("12");
    }

    public int numDecodings(String s) {
        if (s.startsWith("0")){
            return 0;
        }

        int length = s.length();
        //dp[i]表示到当前位置为止有多少种解码方式
        int[] dp = new int[length + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2 ; i <= length ; i++){
            int current = s.charAt(i - 1) - '0';
            int before = s.charAt(i - 2) - '0';
            int sum = before * 10 + current;

            //这是不可能出现的编码格式
            if (sum == 0){
                return 0;
            }
            if (current == 0 && sum > 20){
                return 0;
            }

            if (current != 0){
                if (sum > 0 && sum < 27 && before > 0){
                    dp[i] = dp[i - 1] + dp[i - 2];
                }else {
                    dp[i] = dp[i - 1];
                }
            }else {
                dp[i] = dp[i - 2];
            }
        }

        return dp[length];
    }
}
