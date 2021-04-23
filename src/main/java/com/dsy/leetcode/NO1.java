package com.dsy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NO1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            if (cache.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = cache.get(target - nums[i]);
            }else {
                cache.put(nums[i], i);
            }
        }
        return result;
    }
}
