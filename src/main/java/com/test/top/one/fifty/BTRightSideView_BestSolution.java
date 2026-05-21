package com.test.top.one.fifty;

import java.util.*;

public class BTRightSideView_BestSolution {


    static void main() {
        TreeNode t = new TreeNode(1);
        t.left =new TreeNode( 2);
        t.left.right = new TreeNode(5);
        t.right = new TreeNode(3);
        t.right.right = new TreeNode(4);
        BTRightSideView_BestSolution btRightSideView =new BTRightSideView_BestSolution();
        btRightSideView.rightSideView(t);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> val = new ArrayList<>();
        if(root == null){
            return val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int nodeSize = queue.size();
            for(int i = 0;i< nodeSize;i++){
                var currentNode = queue.poll();
                if(i ==nodeSize-1){
                    val.add(currentNode.val);
                }
                if(currentNode.left!= null)queue.offer(currentNode.left);
                if(currentNode.right!= null)queue.offer(currentNode.right);
            }
        }
        return val;
    }



}

