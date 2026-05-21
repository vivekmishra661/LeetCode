package com.test.top.one.fifty;

import org.example.ListNode;

public class HasCycle_BestSolution {

    static void main() {
        HasCycle_BestSolution h = new HasCycle_BestSolution();
        ListNode l = new ListNode(-1);
        var t1  =new ListNode(-7);
        var t2 = new ListNode(7);
        var t3 = new ListNode(-4);
        var t4 = new ListNode(19);
        var t5 = new ListNode(6);
        var t6 = new ListNode(-9);
        var t7 = new ListNode(-5);
        var t8 = new ListNode(-2);
        var t9 = new ListNode(-5);
        l.next= t1;
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        t5.next = t6;
        t6.next = t7;
        t7.next = t8;
        t8.next = t9;
        t9.next = t9;
        h.hasCycle(l);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head; // moves 1 step
        ListNode fast = head; // moves 2 steps

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected!
            }
        }

        return false; // Fast reached the end; no cycle.
    }
}


