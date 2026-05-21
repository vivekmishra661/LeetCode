package com.test.top.one.fifty;

import java.util.concurrent.atomic.AtomicBoolean;

public class BTSameTree_OptimumSolution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        AtomicBoolean isSameTree = new AtomicBoolean(true);
        traverse(p,q,isSameTree);
        return isSameTree.get();
    }

    public void traverse(TreeNode p, TreeNode q, AtomicBoolean isSametree) {
        if (p == null && q == null) return;
        if ((p != null && q == null) || (q != null && p == null)) {
            isSametree.set(false);
            return;
        }
        if (p.val != q.val) {
            isSametree.set(false);
            return;
        }

        if (isSametree.get()) {
            var pLeftTree = p.left;
            var qLeftTree = q.left;
            traverse(pLeftTree, qLeftTree, isSametree);
        }
        if (isSametree.get()) {
            var pRightTree = p.right;
            var qRightTree = q.right;
            traverse(pRightTree, qRightTree, isSametree);
        }

    }
}
