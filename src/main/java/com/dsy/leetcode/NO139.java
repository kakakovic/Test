package com.dsy.leetcode;

import java.util.Arrays;
import java.util.List;

public class NO139 {
    public static void main(String[] args) {
        NO139 no139 = new NO139();
        no139.wordBreak("leetcode", Arrays.asList("leet", "code"));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]表示s中前i个元素组成的子字符串是不是可以被拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1 ; i <= s.length() ; i++){
            for (int j = i - 1 ; j >= 0 ; j--){
                if (dp[j]){
                    String current = s.substring(j, i);
                    if (wordDict.contains(current)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length()];
    }
}
