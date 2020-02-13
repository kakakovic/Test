//package com.dsy.leetcode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class NO541 {
//    public String reverseStr(String s, int k) {
//        List<String> result = new ArrayList<>();
//        int slots = s.length() / (2 * k);
//        for (int i = 0 ; i < slots ; i++){
//            String x = s.substring(2 * k * i, 2 * k * i + 2 * k);
//            result.add(x);
//        }
//        for (String x : result){
//
//        }
//    }
//
//    public String reverse(String s){
//        char[] tmp = s.toCharArray();
//        for (int i = 0 ; i < (tmp.length/2) ; i++){
//            char x = tmp[i];
//            tmp[i] = tmp[tmp.length - i];
//            tmp[tmp.length - i] = x;
//        }
//        return new String(tmp);
//    }
//}
