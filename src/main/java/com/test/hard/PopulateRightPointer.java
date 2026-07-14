package com.test.hard;


import java.util.ArrayList;
import java.util.List;

public class PopulateRightPointer {

    public Node connect(Node root) {
        //implement BFS
        List<Node> currentNode = new ArrayList<>();
        currentNode.add(root);
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        while (true) {
            List<Node> p = new ArrayList<>();
            for (Node n : currentNode) {
                if (n.left != null)
                    p.add(n.left);
                if (n.right != null)
                    p.add(n.right);
            }
            if (p.isEmpty()) {
                break;
            }
            currentNode.clear();
            currentNode.addAll(p);
            for (int i = 0; i < currentNode.size() - 1; i++) {
                currentNode.get(i).next = currentNode.get(i + 1);
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
