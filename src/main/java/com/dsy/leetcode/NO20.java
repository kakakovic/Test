package com.dsy.leetcode;

import java.util.Stack;

public class NO20 {
    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char last = stack.pop();
                if (c == ')' && last != '('){
                    return false;
                }
                if (c == ']' && last != '['){
                    return false;
                }
                if (c == '}' && last != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
