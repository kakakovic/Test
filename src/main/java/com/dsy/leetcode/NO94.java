package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
}
