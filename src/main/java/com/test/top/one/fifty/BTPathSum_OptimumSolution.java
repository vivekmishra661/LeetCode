package com.test.top.one.fifty;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class BTPathSum_OptimumSolution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root== null) return  false;
        AtomicInteger t = new AtomicInteger(root.val);
        AtomicBoolean x = new AtomicBoolean(false);
        if (t.get() == targetSum && root.left == null && root.right == null) {
            return true;
        }
        traverse(root, t, x, targetSum);

        return x.get();
    }

    private void traverse(TreeNode root, AtomicInteger currentValue, AtomicBoolean x, int targetSum) {

        var left = root.left;
        var right = root.right;
        if(left== null && right == null){
            if (currentValue.get() == targetSum) {
                x.set(true);
                return;
            }
        }
        if (!x.get() && left != null) {
            AtomicInteger k = new AtomicInteger(currentValue.get());
            k.addAndGet(left.val);
            traverse(left, k, x, targetSum);
        }
        if (!x.get() && right != null) {
            AtomicInteger k = new AtomicInteger(currentValue.get());
            k.addAndGet(right.val);
            traverse(right, k, x, targetSum);
        }
    }
}
