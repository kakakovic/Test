package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = travelMid(root);
        for (int i = 1 ; i < list.size() ; i++){
            if (list.get(i) <= list.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    private List<Integer> travelMid(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> left = travelMid(root.left);
        left.add(root.val);
        left.addAll(travelMid(root.right));
        return left;
    }
}
