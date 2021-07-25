package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求解全部解空间，一般使用回溯
 * 回溯往往借助于递归实现
 */
public class NO46 {

    List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {
        backTrack(new ArrayList<>(), nums);
        return result;
    }

    private void backTrack(List<Integer> currentList, int[] nums){
        if (currentList.size() == nums.length){
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int num : nums){
            if (currentList.contains(num)){
                continue;
            }
            currentList.add(num);
            backTrack(currentList, nums);
            currentList.remove(currentList.size() - 1);
        }
    }
}
