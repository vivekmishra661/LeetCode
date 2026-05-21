package com.test.top.one.fifty;

public class BTInvertTree_BestSolution {

    static void main() {
        TreeNode t = new TreeNode(2);
        t.right = new TreeNode(3);
       // t.left = new TreeNode(1);
        BTInvertTree_BestSolution btInvertTree = new BTInvertTree_BestSolution();
        btInvertTree.invertTree(t);
    }

    public TreeNode invertTree(TreeNode root) {
        traverse(root, null, false);
        return root;
    }

    public void traverse(TreeNode p, TreeNode parent, boolean isLeft) {
        if (p == null) return;
        if (p.left == null && p.right == null) {
            if (parent == null) return;
            if (isLeft) {
                var t = parent.right;
                parent.right = p;
                parent.left = t;
            } else {
                var t = parent.left;
                parent.left = p;
                parent.right = t;
            }
            return;
        }
        var t = p.right;
        p.right = p.left;
        p.left = t;
        var pLeftTree = p.left;
        if (pLeftTree != null && (pLeftTree.left != null || pLeftTree.right != null)) {
            traverse(pLeftTree, p, true);
        }
        var pRightTree = p.right;
        if (pRightTree != null && (pRightTree.left != null || pRightTree.right!= null)) {
            traverse(pRightTree, p, false);
        }


    }

}
