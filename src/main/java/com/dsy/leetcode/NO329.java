package com.dsy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NO329 {
    public static void main(String[] args) {
        NO329 no329 = new NO329();
        int[][] nums = new int[][]{new int[]{3,4,5}, new int[]{3,2,6}, new int[]{2,2,1}};
        no329.longestIncreasingPath(nums);
    }

    Map<String, Integer> dynamicCache = new HashMap<>();

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0 ; j < matrix[0].length ; j++){
                max = Math.max(max, dynamic(i, j, matrix, -1));
            }
        }
        return max;
    }

    private int dynamic(int i, int j, int[][]matrix, int origin){
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= origin){
            return 0;
        }
        if (dynamicCache.containsKey(i + "," + j)){
            return dynamicCache.get(i + "," + j);
        }
        int up = i > 0 ? dynamic(i - 1, j, matrix, matrix[i][j]) : 0;
        int down = i < matrix.length - 1 ? dynamic(i + 1, j, matrix, matrix[i][j]) : 0 ;
        int left = j > 0 ? dynamic(i, j - 1, matrix, matrix[i][j]) : 0;
        int right = j < matrix[0].length - 1 ? dynamic(i, j +1, matrix, matrix[i][j]) :0;
        int max;
        max = Math.max(up, down);
        max = Math.max(max, left);
        max = Math.max(max, right);
        dynamicCache.put(i + "," + j, 1 + max);
        return 1 + max;
    }
}
