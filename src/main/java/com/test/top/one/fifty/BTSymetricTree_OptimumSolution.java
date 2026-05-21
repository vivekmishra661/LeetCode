package com.test.top.one.fifty;

import java.util.concurrent.atomic.AtomicBoolean;

public class BTSymetricTree_OptimumSolution {

    static void main() {
        TreeNode t = new TreeNode();
        t.left = new TreeNode(2);
        t.right = new TreeNode(2);
        t.left.right = new TreeNode(3);
        t.right.right = new TreeNode(3);
        BTSymetricTree_OptimumSolution btSymetricTree= new BTSymetricTree_OptimumSolution();
        btSymetricTree.isSymmetric(t);
    }

    public boolean isSymmetric(TreeNode root) {
        AtomicBoolean s = new AtomicBoolean(true);
        bfs(root.left, root.right,s);
        return s.get();
    }

    public void bfs(TreeNode left, TreeNode right, AtomicBoolean s) {
        if (left == null && right == null) {
            return;
        } else if ((left != null && right == null) || (left == null && right != null)) {
            s.set(false);
            return;
        }
        if (left.val != right.val) {
            s.set(false);
            return;
        } else {
            bfs(left.left, right.right, s);
            bfs(left.right, right.left, s);
        }

    }
}
