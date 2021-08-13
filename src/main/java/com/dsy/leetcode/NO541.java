package com.dsy.leetcode;

import java.util.*;

public class NO541 {
    public String reverseStr(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        int length = 2 * k;
        int count = 0;
        for (int i = 0 ; i < s.length() ; i++){
            queue.add(s.charAt(i));
            count++;
            if (count % length == 0){
                Stack<Character> tmp = new Stack<>();
                for (int j = 1 ; j <= k ; j++){
                    tmp.add(queue.poll());
                }
                while (!tmp.empty()){
                    stringBuilder.append(tmp.pop());
                }
                while (!queue.isEmpty()){
                    stringBuilder.append(queue.poll());
                }
            }
        }
        if (queue.isEmpty()){
            return stringBuilder.toString();
        }else {
            int size = queue.size();
            Stack<Character> tmp = new Stack<>();
            for (int j = 1 ; j <= k && j <= size ; j++){
                tmp.add(queue.poll());
            }
            while (!tmp.empty()){
                stringBuilder.append(tmp.pop());
            }
            while (!queue.isEmpty()){
                stringBuilder.append(queue.poll());
            }
            return stringBuilder.toString();
        }
    }
}
