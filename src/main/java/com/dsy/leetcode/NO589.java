package main.java.com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        for (Node child : root.children){
            result.addAll(preorder(child));
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}


