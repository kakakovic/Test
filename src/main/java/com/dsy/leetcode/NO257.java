package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO257 {
    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        backTrack("", root);
        return res;
    }

    private void backTrack(String current, TreeNode currentNode){
        if (currentNode.left == null && currentNode.right == null){
            current = current + currentNode.val;
            res.add(current);
            return;
        }
        current = current + currentNode.val + "->";
        if (currentNode.left != null){
            backTrack(current, currentNode.left);
        }
        if (currentNode.right != null){
            backTrack(current, currentNode.right);
        }
    }
}
