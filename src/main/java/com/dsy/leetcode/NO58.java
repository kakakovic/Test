package com.dsy.leetcode;

public class NO58 {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1 ; i >= 0 ; i--){
            if (count == 0){
                if (s.charAt(i) != ' '){
                    count = 1;
                }
            }else {
                if (s.charAt(i) != ' '){
                    count++;
                }else {
                    return count;
                }
            }
        }
        return count;
    }
}
