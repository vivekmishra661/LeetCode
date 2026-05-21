package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.List;

public class BSTMinAbsDiff_OptimimumSolution {

    static void main() {
        BSTMinAbsDiff_OptimimumSolution bstMinAbsDiff = new BSTMinAbsDiff_OptimimumSolution();
        TreeNode t = new TreeNode(236);
        t.left = new TreeNode(104);
        t.left.right = new TreeNode(227);
        t.right = new TreeNode(701);
        t.right.right = new TreeNode(911);
        bstMinAbsDiff.getMinimumDifference(t);
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> t = new ArrayList<>();
        dfsInorder(root, t);
        int min = Integer.MAX_VALUE;
        for(int i  =0 ;i< t.size()-1;i++){
            if((t.get(i+1)-t.get(i)<min))
                min = t.get(i+1)-t.get(i);
        }
        return min;
    }


    private void dfsInorder(TreeNode treeNode, List<Integer> list) {

        if (treeNode == null) return;
        dfsInorder(treeNode.left, list);
        list.add(treeNode.val);
        dfsInorder(treeNode.right, list);

    }
}
