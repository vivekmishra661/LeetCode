package com.test.top.one.fifty;

import java.util.concurrent.atomic.AtomicInteger;

public class BTSumRootToLeaf_BestSolution {

    static void main() {
        BTSumRootToLeaf_BestSolution t = new BTSumRootToLeaf_BestSolution();
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(0);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(1);
        t.sumNumbers(treeNode);
    }

    public int sumNumbers(TreeNode root) {

        //apply dfs
       int multiplier = 1;
        AtomicInteger sum = new AtomicInteger(0);
        int current = root.val;
        traverse(root, current, sum);
        return sum.get();


    }


    public void traverse(TreeNode currentNode,  int current,  AtomicInteger sum){

        if(currentNode!= null){
            var left  = currentNode.left;
            var right  = currentNode.right;
            if(left == null && right == null){
              sum.addAndGet(current);
            }else{
                if(left!= null){
                    int currentL = (current*10) + left.val;
                    traverse(left, currentL, sum);
                }
                if(right!= null){
                    int currentR = (current*10) + right.val;
                    traverse(right, currentR, sum);
                }
            }

        }

    }

}
