package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListWithRandomPointer_OptimumSolution {

    public Node copyRandomList(Node head) {
        Node copy  = null;
        if(head == null){
            return null;
        }
        int count =0;
        Map<Integer, Node> randomNodeRef = new HashMap<>();
        Map<Node, Integer> nodeRef = new HashMap<>();
        List<Node> l = new ArrayList<>();
        boolean isInitial = true;
        Node currentNode = null;
        while(head!= null){

            if(isInitial){
                copy = new Node(head.val);
                currentNode = copy;
                isInitial =false;
            }else{
                currentNode.next = new Node(head.val);
                currentNode = currentNode.next;
            }

            randomNodeRef.put(count, head.random);

            nodeRef.put(head, count);
            l.add(currentNode);
            head = head.next;

            count++;
        }

        var t = copy;
        System.out.println(nodeRef.toString());
        System.out.println(randomNodeRef.toString());
        System.out.println(copy);
        for(int i =0;i<count;i++){
            var node = randomNodeRef.get(i);
            if(node != null) {
                var index = nodeRef.get(node);
                if(index != null)
                    copy.random = l.get(index);
            }
            copy = copy.next;
        }
        return  t;

    }



}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
