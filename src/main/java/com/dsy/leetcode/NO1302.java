package com.dsy.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NO1302 {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        currentQueue.add(root);
        int lineSum = 0;
        while (currentQueue.size() != 0){
            TreeNode node = currentQueue.poll();
            lineSum += node.val;
            if (node.left != null){
                nextQueue.add(node.left);
            }
            if (node.right != null){
                nextQueue.add(node.right);
            }
            if (currentQueue.size() == 0){
                if (nextQueue.size() == 0){
                    return lineSum;
                }else {
                    lineSum = 0;
                    currentQueue = nextQueue;
                    nextQueue = new LinkedList<>();
                }
            }
        }
        return 0;
    }
}
