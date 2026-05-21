package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.List;

public class BSTValidateBinaryTree_Revisit {


    public boolean isValidBST(TreeNode root) {
        int max = Integer.MIN_VALUE;

        List<Integer> t = new ArrayList<>();

        dfsInorder(root, t);
        for(int i  =0 ;i< t.size()-1;i++){
            if(t.get(i)>=t.get(i+1)){
                return false;
            }
        }
        return true;

    }

    private void dfsInorder(TreeNode treeNode, List<Integer> list) {

        if (treeNode == null) return;
        dfsInorder(treeNode.left, list);
        list.add(treeNode.val);
        dfsInorder(treeNode.right, list);

    }
}
