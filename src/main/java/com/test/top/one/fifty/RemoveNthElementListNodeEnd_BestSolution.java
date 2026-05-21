package com.test.top.one.fifty;

import org.example.ListNode;

public class RemoveNthElementListNodeEnd_BestSolution {

    static void main() {
        RemoveNthElementListNodeEnd_BestSolution l = new RemoveNthElementListNodeEnd_BestSolution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next =l2;
        l2.next = l3;
        l3.next =l4;
        l4.next = l5;
        l.removeNthFromEnd(l1, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 1;
        ListNode full = head;

        if(head.next== null){
            return null;
        }

        while (head != null) {
            var next = head.next;
            if (next != null) {
                var nextToNext = next.next;
                if (nextToNext != null) {
                    count += 2;
                    head = nextToNext;
                } else {
                    count += 1;
                    break;
                }
            } else {
                break;
            }
        }
        int first = count - n +1;
        head = full;
        count = 1;
        while (head != null) {
            if(first ==1){
                full = full.next;
                break;
            }
            var next = head.next;
            if (next != null && first == count + 1) {
                var nextToNext = next.next;
                head.next = nextToNext;
                break;
            } else if (next != null) {
                var nextToNext = next.next;
                if (nextToNext != null && first == count + 2) {
                    var k = nextToNext.next;
                    next.next = k;
                    break;
                }
            }

            head = head.next.next;
            count = count+2;

        }

        return full;

    }
}
