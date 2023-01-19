package com.dsy.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class NO22 {
    public static void main(String[] args) {
        NO22 no22 = new NO22();
        List<String> res = no22.generateParenthesis(3);
        System.out.println(JSON.toJSONString(res));
    }

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack("", n);
        return result;
    }

    private void backTrack(String current, int n){
        if (current.length() == 2 * n && !result.contains(current)){
            result.add(current);
            return;
        }
        List<String> available = new ArrayList<>();
        int left = getLeftBrackets(current);
        int right = getRightBrackets(current);
        if (left < n){
            available.add("(");
        }
        if (right < left){
            available.add(")");
        }
        for (String s : available){
            current = current + s;
            backTrack(current, n);
            current = current.substring(0, current.length() - 1);
        }
    }

    private int getLeftBrackets(String current){
        int result = 0;
        for (int i = 0 ; i < current.length() ; i++){
            char c = current.charAt(i);
            if (c == '('){
                result++;
            }
        }
        return result;
    }

    private int getRightBrackets(String current){
        int result = 0;
        for (int i = 0 ; i < current.length() ; i++){
            char c = current.charAt(i);
            if (c == ')'){
                result++;
            }
        }
        return result;
    }
}
