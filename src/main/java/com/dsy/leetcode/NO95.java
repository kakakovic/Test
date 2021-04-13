package com.dsy.leetcode;

import java.util.*;

public class NO95 {
    public static void main(String[] args) {
        NO95 no95 = new NO95();
        no95.generateTrees(1, 3);
    }

    /**
     * 自底向上的动态规划
     */
    Map<String, List<TreeNode>> dp = new HashMap<>();

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        if (dp.containsKey(start + "_" + end)){
            return dp.get(start + "_" + end);
        }
        List<TreeNode> result = new ArrayList<>();
        if (end < start){
            return result;
        }
        if (end == start){
            TreeNode treeNode = new TreeNode(end);
            result.add(treeNode);
            return result;
        }
        for (int i = start ; i <= end ; i++){
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            if (left.size() > 0 && right.size() > 0){
                for (TreeNode leftNode : left){
                    for (TreeNode rightNode : right){
                        TreeNode treeNode = new TreeNode(i);
                        treeNode.left = leftNode;
                        treeNode.right = rightNode;

                        result.add(treeNode);
                    }
                }
            }else if (left.size() > 0){
                for (TreeNode leftNode : left){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    result.add(treeNode);
                }
            }else {
                for (TreeNode rightNode : right){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.right = rightNode;
                    result.add(treeNode);
                }
            }
        }
        dp.put(start + "_" + end, result);
        return result;
    }
}
