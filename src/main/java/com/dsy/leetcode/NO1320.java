package com.dsy.leetcode;

public class NO1320 {

    public int distance(int start, int end){
        int startRow = start / 6;
        int endRow = end / 6;
        int startCol = start % 6;
        int endCol = end % 6;
        return Math.abs(startRow - endRow) + Math.abs(startCol - endCol);
    }
}
