package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
}
