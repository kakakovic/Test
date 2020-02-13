package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO1324 {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        List<String> res = new ArrayList<>();
        int max = 0;
        for (String i : words)
            max = Math.max(max, i.length());
        StringBuilder[] word = new StringBuilder[max];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < words.length; j++) {
                if (word[i] == null) word[i] = new StringBuilder();
                if (i < words[j].length()) {
                    word[i].append(words[j].charAt(i));
                } else
                    word[i].append(" ");
            }
        }

        for (StringBuilder sb : word) {
            int i = sb.length() - 1;
            while (sb.charAt(i) == ' ') {
                sb.deleteCharAt(i);
                i--;
            }
            res.add(sb.toString());
        }
        return res;
    }
}
