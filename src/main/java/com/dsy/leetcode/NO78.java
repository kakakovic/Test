package com.dsy.leetcode;

import java.util.*;

public class NO78 {
    private List<List<Integer>> result = new ArrayList<>();

    private Set<String> signSet = new HashSet<>();

    public static void main(String[] args) {
        NO78 no78 = new NO78();
        no78.subsets(new int[]{1, 2, 3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        backTrack(new ArrayList<>(), nums);
        return result;
    }

    /**
     * 在当前current已有的基础上，尽可能得排列nums，并把结果反馈到current
     */
    private void backTrack(List<Integer> current, int[] nums){
        String sign = getSign(current);
        if (!signSet.contains(sign)){
            signSet.add(sign);
            result.add(new ArrayList<>(current));
        }
        for (int num : nums){
            if (current.size() != 0){
                int last = current.get(current.size() - 1);
                if (num < last){
                    continue;
                }
            }
            if (current.contains(num)){
                continue;
            }
            current.add(num);
            backTrack(current, nums);
            current.remove(current.size() - 1);
        }
    }

    private String getSign(List<Integer> list){
        list.sort(Integer::compareTo);
        StringJoiner stringJoiner = new StringJoiner(",");
        for (Integer num : list){
            stringJoiner.add(num.toString());
        }
        return stringJoiner.toString();
    }
}
