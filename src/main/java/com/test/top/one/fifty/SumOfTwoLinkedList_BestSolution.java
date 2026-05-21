package com.test.top.one.fifty;

import org.example.ListNode;

public class SumOfTwoLinkedList_BestSolution {




    static void main() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);
        l1.next =l2;
        l2.next =l3;
        r1.next = r2;
        r2.next = r3;
        SumOfTwoLinkedList_BestSolution sumOfTwoLinkedListOptimumSolution = new SumOfTwoLinkedList_BestSolution();
        sumOfTwoLinkedListOptimumSolution.addTwoNumbers(l1,r1);

    }


    public ListNode addTwoNumbers(ListNode a, ListNode b){
        int remainder = 0;
        var t= a;
        while(a != null || b!= null){
            int val = a.val + b.val + remainder ;
            if(val>=10){
                val = val-10;
                remainder = 1;
            }else{
                remainder= 0;
            }
           a.val = val;
            if(a.next ==null && b.next == null && remainder==0){
                break;
            }
           if(a.next ==null){
               a.next = new ListNode(0);
           }
           if(b.next ==null){
               b.next = new ListNode(0);
           }

           b= b.next;
           a= a.next;

        }
        return t;
    }
}


