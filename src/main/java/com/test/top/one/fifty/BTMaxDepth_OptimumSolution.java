package com.test.top.one.fifty;

import java.util.concurrent.atomic.AtomicInteger;

public class BTMaxDepth_OptimumSolution {

    public int maxDepth(TreeNode root) {
        AtomicInteger left = new AtomicInteger(0);
        AtomicInteger right = new AtomicInteger(0);
        AtomicInteger max = new AtomicInteger(0);
        traverse(root, left,right,max);
        return max.get();
    }

    public void traverse(TreeNode tree, AtomicInteger left, AtomicInteger right, AtomicInteger max) {
        if(tree == null)return;
        var lefttree = tree.left;
        if (left != null) {
            var currentLeft = new AtomicInteger(left.incrementAndGet());
            var currentRight = new AtomicInteger(right.get());
            traverse(lefttree, currentLeft, currentRight, max);
            if (max.get() < currentRight.get())
                max.set(currentRight.get());
            if (max.get() < currentLeft.get())
                max.set(currentLeft.get());
        }
        var rightTree = tree.right;
        if (rightTree != null) {
            var currentLeft = new AtomicInteger(left.get());
            var currentRight = new AtomicInteger(right.incrementAndGet());
            traverse(rightTree, left, right, max);
            if (max.get() < currentRight.get())
                max.set(currentRight.get());
            if (max.get() < currentLeft.get())
                max.set(currentLeft.get());

        }


    }
}
