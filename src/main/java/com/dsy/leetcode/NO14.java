package com.dsy.leetcode;

import java.util.Arrays;

public class NO14 {
    /**
     * 第i个元素记录了到i为止的最长公共前缀
     */
    private String[] dynamic = new String[200];

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            dynamic[0] = strs[0];
            return strs[0];
        }
        for (int i = 1 ; i < strs.length ; i++){
            String prefix;
            //通过动态规划避免递归过程中遇到的重叠子问题
            if (dynamic[i - 1] != null){
                prefix = dynamic[i - 1];
            }else {
                String[] subArray = Arrays.copyOf(strs, i);
                prefix = longestCommonPrefix(subArray);
            }
            String current = strs[i];
            String result = getCommonPrefix(current, prefix);
            dynamic[i] = result;
        }
        return dynamic[strs.length - 1];
    }

    private String getCommonPrefix(String a, String b){
        int lengthA = a.length();
        int lengthB = b.length();
        int length = Math.min(lengthA, lengthB);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < length ; i++){
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);
            if (aChar == bChar){
                stringBuilder.append(aChar);
            }else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
