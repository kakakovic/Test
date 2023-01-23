package com.dsy.leetcode;

import java.util.*;

public class NO47 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> shell = new ArrayList<>();
        for (int num : nums){
            shell.add(num);
        }
        backTrack(new ArrayList<>(), shell);
        return res;
    }

    private void backTrack(List<Integer> current, List<Integer> nums){
        if (current.size() == nums.size()){
            res.add(new ArrayList<>(current));
            return;
        }
        Set<Integer> available = new HashSet<>(subtract(nums, current));
        for (int num : available){
            current.add(num);

            backTrack(current, nums);
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
}
