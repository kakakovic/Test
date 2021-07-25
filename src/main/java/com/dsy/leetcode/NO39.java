package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NO39 {
    public static void main(String[] args) {
        NO39 no39 = new NO39();
        no39.combinationSum(new int[]{2,3,5}, 8);
    }

    private List<List<Integer>> result = new ArrayList<>();

    private Set<String> signList = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(new ArrayList<>(), target, candidates);
        return result;
    }

    private void backTrack(List<Integer> current, int target, int[] candidates){
        if (target == 0){
            List<Integer> tmp = new ArrayList<>(current);
            tmp.sort(Integer::compareTo);
            StringBuilder sign = new StringBuilder();
            for (Integer integer : tmp){
                sign.append(integer).append(",");
            }
            if (signList.contains(sign.toString())){
                return;
            }
            signList.add(sign.toString());
            result.add(tmp);
            return;
        }else {
            for (int num :candidates){
                current.add(num);
                int remain = target - num;
                if (remain >= 0){
                    backTrack(current, target - num, candidates);
                }
                current.remove(current.size() - 1);
            }
        }
    }


}
