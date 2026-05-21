package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.List;

public class BSTKthSmallElement_OptimimumSolution {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> t = new ArrayList<>();
        dfsInorder(root, t);
        return t.get(k-1);
    }

    private void dfsInorder(TreeNode treeNode, List<Integer> list) {

        if (treeNode == null) return;
        dfsInorder(treeNode.left, list);
        list.add(treeNode.val);
        dfsInorder(treeNode.right, list);

    }
}
