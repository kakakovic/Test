package com.dsy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NO236 {
    private Map<String, Boolean> cache = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val){
            return root;
        }
        boolean leftP = contains(root.left, p);
        boolean leftQ = contains(root.left, q);
        boolean rightP = contains(root.right, p);
        boolean rightQ = contains(root.right, q);

        if (leftP && leftQ){
            return lowestCommonAncestor(root.left, p, q);
        }else if (rightP && rightQ){
            return lowestCommonAncestor(root.right, p, q);
        }else {
            return root;
        }
    }

    private boolean contains(TreeNode root, TreeNode value){
        if (root == null){
            return false;
        }
        if (root.val == value.val){
            return true;
        }
        String cacheKey = root.val + "_" + value.val;
        if (cache.containsKey(cacheKey)){
            return cache.get(cacheKey);
        }
        boolean result = contains(root.left, value) || contains(root.right, value);
        cache.put(cacheKey, result);
        return result;
    }
}
