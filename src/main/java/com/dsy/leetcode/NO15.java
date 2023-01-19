package com.dsy.leetcode;

import java.util.*;

public class NO15 {
    private Set<String> signSet = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0 ; i < nums.length ; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            res.addAll(findSum(nums, i));
        }

        return res;
    }

    private List<List<Integer>> findSum(int[] nums, int skipIndex){
        int target = -nums[skipIndex];
        List<List<Integer>> res = new ArrayList<>();

        int start = skipIndex == 0 ? 1 : 0;
        int end = skipIndex == nums.length - 1 ? skipIndex - 1 : nums.length - 1;
        while (end > start){
            int startVal = nums[start];
            int endVal = nums[end];
            int sum = startVal + endVal;
            if (sum == target){
                List<Integer> innerRes = new ArrayList<>();
                innerRes.add(startVal);
                innerRes.add(endVal);
                if (-target < startVal){
                    innerRes.add(0, -target);
                }else if (-target > endVal){
                    innerRes.add(2, -target);
                }else {
                    innerRes.add(1, -target);
                }

                String sign = innerRes.get(0) + "_" + innerRes.get(1) + "_" + innerRes.get(2);
                if (!signSet.contains(sign)){
                    res.add(innerRes);
                    signSet.add(sign);
                }

                start++;
                if (start == skipIndex){
                    start++;
                }
            }else if (sum < target){
                start++;
                if (start == skipIndex){
                    start++;
                }
            }else {
                end--;
                if (end == skipIndex){
                    end--;
                }
            }
        }

        return res;
    }
}
