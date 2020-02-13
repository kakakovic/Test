package com.dsy.leetcode;

import java.util.*;

public class NO1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> left = preOrder(root1);
        List<Integer> right = preOrder(root2);
        return merge(left,right);
    }

    public List<Integer> preOrder(TreeNode node){
        List<Integer> result = new ArrayList<>();
        if (node == null){
            return result;
        }
        result.addAll(preOrder(node.left));
        result.add(node.val);
        result.addAll(preOrder(node.right));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NO1305().merge(Collections.emptyList(), Arrays.asList(0,1,3)));
    }

    public List<Integer> merge(List<Integer> left, List<Integer> right){
        List<Integer> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        int leftSize = left.size();
        int rightSize = right.size();
        while (leftIndex < leftSize && rightIndex < rightSize){
            int a = left.get(leftIndex);
            int b = right.get(rightIndex);
            if (a <= b){
                result.add(a);
                leftIndex++;
            }else {
                result.add(b);
                rightIndex++;
            }
        }
        for (int i = leftIndex; i < leftSize ; i++){
            result.add(left.get(i));
        }
        for (int i = rightIndex ; i < rightSize ; i++){
            result.add(right.get(i));
        }
        return result;
    }
}
