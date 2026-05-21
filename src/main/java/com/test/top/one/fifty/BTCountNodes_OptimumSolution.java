package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BTCountNodes_OptimumSolution {

    public int countNodes(TreeNode root) {
        AtomicInteger count =new AtomicInteger(0);
        if(root ==null) return 0;
        if(root.left == null && root.right == null ) return 1;
        List<TreeNode> collection = List.of(root);
        while(true){
            List<TreeNode> collection1 = new ArrayList<>();
            if(collection.isEmpty())
                break;
            collection.forEach(k ->{
                if(k.left != null) {
                   count.incrementAndGet();
                    collection1.add(k.left);
                }
                if(k.right != null){
                    count.incrementAndGet();
                    collection1.add(k.right);
                }
            });
            collection= null;
            collection.addAll(collection1);

        }
        return count.get();
    }
}
