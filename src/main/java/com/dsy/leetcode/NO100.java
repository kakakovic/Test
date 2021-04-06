package com.dsy.leetcode;

public class NO100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else{
            if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val){
                return true;
            }else{
                return false;
            }
        }
    }
}
