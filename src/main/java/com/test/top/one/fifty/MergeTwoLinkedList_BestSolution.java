package com.test.top.one.fifty;

import org.example.ListNode;

public class MergeTwoLinkedList_BestSolution {

    static void main() {
        ListNode l1 = new ListNode(-8);
        ListNode l2 = new ListNode(-7);
        l1.next = l2;
        ListNode l3 = new ListNode(-4);
        l2.next = l3;
        ListNode l4 = new ListNode(0);
        l3.next = l4;
        ListNode l5 = new ListNode(7);
        l4.next =l5;
        ListNode l6 = new ListNode(8);
        l5.next = l6;
        ListNode l7 = new ListNode(9);
        l6.next= l7;
        ListNode r1 = new ListNode(-3);
        var t=  new MergeTwoLinkedList_BestSolution();
        t.mergeTwoLists(l1,r1);

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode n = new ListNode();
        var t = n;
        ListNode previous  = null;
        if(list1== null && list2 ==null){
            return null;
        }
        while(list1!= null || list2 != null){

            if(list1 ==null){
                n.val = list2.val;
                n.next = list2.next;
                return  t;
            }else if(list2 == null){
                n.val = list1.val;
                n.next = list1.next;
                return  t;
            }

            var val1 = list1.val;
            var val2 = list2.val;
            if(val1> val2){
                n.val = val2;
                n.next = new ListNode();
                previous = n;
                n = n.next;
                list2 = list2.next;
            }else if(val1< val2){
                n.val = val1;
                n.next = new ListNode();
                previous = n;
                n = n.next;
                list1 = list1.next;
            }else if(val1 == val2){
                n.val = val1;
                n.next = new ListNode();
                n.next.val = val2;
                n.next.next = new ListNode();
                previous = n.next;
                n = n.next.next;
                list2 = list2.next;
                list1 = list1.next;

            }
        }

        if(previous!= null && previous.next!= null && previous.next.val ==0){
            previous.next =null;
        }



        return t;

    }
}
