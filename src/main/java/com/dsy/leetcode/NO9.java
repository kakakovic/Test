package com.dsy.leetcode;

public class NO9 {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        String xStr = String.valueOf(x);
        int i = 0;
        int j = xStr.length() - 1;
        while (j - i >= 1){
            char front = xStr.charAt(i);
            char back = xStr.charAt(j);
            if (front != back){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
