package com.test.top.one.fifty;

import java.util.*;

public class BTZigZagOrderTraversal_BestSolution {

    static void main() {
        TreeNode t  = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        BTZigZagOrderTraversal_BestSolution btZigZagOrderTraversal = new BTZigZagOrderTraversal_BestSolution();
        btZigZagOrderTraversal.zigzagLevelOrder(t);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> k = new ArrayList<>();
        if(root ==null){
            return k;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight  =true;

        queue.offer(root);
        while(!queue.isEmpty()){
            int nodeSize = queue.size();
            if(leftToRight){
                List<Integer> values  = new ArrayList<>();
                for(int i =0;i<nodeSize; i++){
                    var currentNode = queue.poll();
                    values.add(currentNode.val);
                    if(currentNode.left!= null) queue.offer(currentNode.left);
                    if(currentNode.right!= null) queue.offer(currentNode.right);
                }
                leftToRight =false;
                k.add(values);
            }else{
                Stack<Integer> values  = new Stack<Integer>();
                for(int i =0;i<nodeSize; i++){
                    var currentNode = queue.poll();
                    values.add(currentNode.val);
                    if(currentNode.left!= null) queue.offer(currentNode.left);
                    if(currentNode.right!= null) queue.offer(currentNode.right);
                }
                leftToRight =true;
                k.add(values.reversed());
            }
        }

        return k;

    }

}
