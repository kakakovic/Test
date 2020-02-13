package com.dsy.leetcode;

public class NO1323 {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        char[] tmp = s.toCharArray();
        for (int i = 0 ; i < tmp.length ; i++){
            if (tmp[i] != '9'){
                tmp[i] = '9';
                break;
            }
        }
        return Integer.valueOf(new String(tmp));
    }
}
