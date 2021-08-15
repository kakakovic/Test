package com.dsy.leetcode;

import java.util.HashSet;

public class NO3 {
    public int lengthOfLongestSubstring(String s) {
        char[] characters = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int leftPointer = 0;
        int rightPointer = 0;
        int length = 0;
        int max = 0;
        while (rightPointer < characters.length){
            if (!set.contains(characters[rightPointer])){
                length++;
                max = Math.max(max, length);
                set.add(characters[rightPointer]);
                rightPointer++;
            }else {
                set.remove(characters[leftPointer]);
                leftPointer++;
                length--;
            }
        }
        return max;
    }
}
