package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SumOfTwoLinkedList {



    public ListNode test(ListNode a, ListNode b){
        boolean isCompleted= false;
        ListNode total = null;
        var bal = 0;
        ListNode previousNode = null;
        while(!isCompleted){
            ListNode currentNode = null;
            if(total ==null){
                total = new ListNode();
                currentNode = total;
            }else{
                currentNode = previousNode.next;
            }
            if(a ==null && b ==null){
                isCompleted = true;
                break;
            }
            int x= a != null ?a.val : 0;
            int y  = b != null? b.val: 0;
            if(x+y+bal>=10) {
                currentNode.val = x + y +bal - 10;
                bal = 1;
            }else{
                bal = 0;
            }

            currentNode.next = new ListNode();
            previousNode = currentNode;
            if(a!= null && a.next!=null)
                a = a.next;
            else
                a = null;
            if(b!= null && b.next != null)
                b = b.next;
            else
                b = null;

        }

        return total;

    }
}

