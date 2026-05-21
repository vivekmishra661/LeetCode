package com.test.top.one.fifty;

import org.example.ListNode;

public class RemoveDupSortList2 {

    static void main() {
        RemoveDupSortList2 l = new RemoveDupSortList2();
        //1,2,3,3,4,4,5
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        l.deleteDuplicates(l1);


    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newList = null;
        //1->2->3->3->4->4->5
        ListNode previous = null;
        while (head != null) {
            if (newList == null) {
                newList = head;
                head = head.next;
            } else {
                var t1 = head.val;
                var t2 = newList.val;
                if (t1 == t2) {
                   head = head.next;
                } else {
                    if(previous ==null){
                        previous = newList;
                    }else{
                        previous.next = newList;
                    }
                    newList = head;
                    head = head.next;
                }


            }
        }
        return previous;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode prevNode = null;
        var full = head;
        while (head != null) {
            if (prevNode == null) {
                prevNode = head;
            } else {
                if (prevNode.val != head.val) {
                    prevNode = head;
                    head = head.next;
                } else {
                    prevNode.next = head.next;
                    head = head.next;
                    //1-1-1-2-2-2-3-3-3
                }
            }
        }
        return full;
    }
}
