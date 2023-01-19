package com.dsy.leetcode;

import java.util.*;

public class NO40 {
    private List<List<Integer>> result = new ArrayList<>();

    private Set<String> signSet = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> shell = new ArrayList<>();
        for (int num : candidates){
            shell.add(num);
        }
        backTrack(new ArrayList<>(), shell, target);
        return result;
    }

    private void backTrack(List<Integer> current, List<Integer> candidates, int target){
        if (target == 0){
            String sign = getSign(new ArrayList<>(current));
            if (signSet.contains(sign)){
                return;
            }
            result.add(new ArrayList<>(current));
            signSet.add(sign);
            return;
        }
        List<Integer> available = subtract(candidates, current);
        Set<Integer> usedNumberInThisLevel = new HashSet<>();
        for (int num : available){
            if (num > target){
                continue;
            }
            if (usedNumberInThisLevel.contains(num)){
                continue;
            }
            usedNumberInThisLevel.add(num);
            current.add(num);

            backTrack(current, candidates, target - num);
            current.remove(current.size() - 1);
        }
    }

    public static List<Integer> subtract(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> list = new ArrayList<>( a );
        for (Iterator<Integer> it = b.iterator(); it.hasNext();) {
            list.remove(it.next());
        }
        return list;
    }

    private String getSign(List<Integer> current){
        Collections.sort(current);
        String x = "";
        for (int num : current){
            x = x + "," + num;
        }
        return x;
    }
}
