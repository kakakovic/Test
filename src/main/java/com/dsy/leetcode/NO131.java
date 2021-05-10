package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NO131 {
    /**
     * dp[i][j]表示s中从i到j位置的子字符串是不是回文字符串
     */
    boolean[][] dp;

    List<List<String>> result = new ArrayList<>();

    Stack<String> current = new Stack<>();

    public static void main(String[] args) {
        NO131 no131 = new NO131();
        System.out.println(no131.partition("cdd"));

    }

    /**
     * 当要遍历满足某个条件的所有解时，一般使用回溯法
     */
    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length()];
        for (int i = 0 ; i < dp.length ; i++){
            for (int j = i ; j >= 0 ; j--){
                dp[i][j] = true;
            }
        }

        for (int i = dp.length - 2 ; i >= 0 ; i--){
            for (int j = dp.length - 1 ; j > i ; j--){
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                }
            }
        }

        dfs(s, 0);

        return result;
    }

    /**
     * @param prefix 当前这次回溯，已经有多少个字符被加入了current数组中；
     */
    private void dfs(String s, int prefix){
        //当前分支走到头了，记录到结果变量中
        if (s.length() == 1){
            current.add(s);
            result.add(new ArrayList<>(current));
        }
        int length = s.length();
        for (int i = 0 ; i < length ; i++){
            if (dp[prefix][prefix + i]){
                current.add(s.substring(0, i + 1));
                dfs(s.substring(i + 1), prefix + i + 1);
                current.pop();
            }
        }
    }
}
