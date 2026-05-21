package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BTAverageOfLevel_BestSolution {

    public List<Double> averageOfLevels(TreeNode root) {
        //go with BFS approach
        List<Double> val = new ArrayList<>();
        //val.add((double) root.val);
        //if(root.left == null && root.right == null){
         //   return val;
        //}
        //List<TreeNode> a = new ArrayList<>();
        //if(root.left!= null)
         //   a.add(root.left);
        //if(root.right!= null)
         //   a.add(root.right);
        //bfs_recursive(a,val);
        bfs(root, val);
        return val;
    }

    private void bfs(TreeNode treeNode, List<Double> val){
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(treeNode);
        while(!queue.isEmpty()){
            int nodeSize  = queue.size();
            double d = 0.0;
            for(int i = 0; i< nodeSize;i++){
                var currentNode = queue.poll();
                d= d+ currentNode.val;
                if(currentNode.left!= null) queue.offer(currentNode.left);
                if(currentNode.right!= null) queue.offer(currentNode.right);
            }
            if(nodeSize>0) {
                double avg = d /new Double(nodeSize);
                val.add(avg);
            }else{
                val.add(0.0);
            }
        }



    }

    private void bfs_recursive(List<TreeNode> nodes, List<Double> val) {
        double value = nodes.stream().filter(e-> e!=null).map(e ->
                new Double(e.val)).reduce((a, b) -> a + b).orElse(0.0);
        if(nodes.size()>0) {
            val.add(value / new Double(nodes.size()));
        }else{
            val.add(0.0);
        }
        var list = nodes.stream().filter(e-> e!=null && e.left != null).map(e -> e.left)
                .collect(Collectors.toList());
        list.addAll(nodes.stream().filter(e-> e!=null  && e.right != null).map(e -> e.right)
                .collect(Collectors.toList()));
        if(!list.isEmpty())
        bfs_recursive(list, val);
    }
}
