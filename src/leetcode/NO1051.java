package leetcode;

import java.util.Arrays;

public class NO1051 {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        int count = 0;
        Arrays.sort(heights);
        for (int i = 0 ; i < heights.length ; i++){
            if (copy[i] != heights[i]) count++;
        }
        return count;
    }
}
