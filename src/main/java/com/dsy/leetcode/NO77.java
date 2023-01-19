package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;

class NO77 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k){
        backTrack(new ArrayList<>(), n ,k);
        return result;
    }

    private void backTrack(List<Integer> current, int n, int k){
        if (current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }
        int max = 0;
        if (current.size() > 0){
            max = current.get(current.size() - 1);
        }
        for (int i = max + 1 ; i <= n ; i++){
            current.add(i);

            backTrack(current, n, k);
            current.remove(current.size() - 1);
        }
    }
}