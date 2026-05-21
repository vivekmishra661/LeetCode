package com.test.top.one.fifty;

import java.util.*;
import java.util.stream.Collectors;

public class BTLevelOrderTraversal_BestSolution {

    static void main() {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        BTLevelOrderTraversal_BestSolution bt = new BTLevelOrderTraversal_BestSolution();
        bt.levelOrder(t);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> val = new ArrayList<>();
        if (root == null) return val;
        bfs(root, val);
        return val;
    }

    //dont use recursive use queue method
    private void bfs(TreeNode root, List<List<Integer>> val) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int nodeSize = queue.size();

            var currentArray = new ArrayList<Integer>();
            for (int i = 0; i < nodeSize; i++) {
                TreeNode currentNode = queue.poll();
                currentArray.add(currentNode.val);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);

            }
            val.add(currentArray);
        }
    }


    private void bfs_recursive(List<TreeNode> nodes, List<List<Integer>> val) {

        var k = nodes.stream().filter(Objects::nonNull).map(e -> e.val)
                .collect(Collectors.toList());
        val.add(k);
        List<TreeNode> list = new ArrayList<>();
        nodes.stream().forEach(root -> {
            if (root.left != null)
                list.add(root.left);
            if (root.right != null)
                list.add(root.right);
        });
        if (!list.isEmpty())
            bfs_recursive(list, val);
    }
}
