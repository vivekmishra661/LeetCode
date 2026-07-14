package com.test.hard;

import org.example.ListNode;

import java.awt.*;
import java.util.List;

public class PartitionList {

    static void main() {
        PartitionList partitionList = new PartitionList();
        partitionList.partition(
                new ListNode(1,
                        new ListNode(4,
                                new ListNode(3,
                                        new ListNode(2,
                                                new ListNode(5,
                                                        new ListNode(2)))))), 3);
    }

    public ListNode partition(ListNode head, int x) {
        int firstPointer = Integer.MAX_VALUE;
        int lastPointer = 0;
        ListNode prev = null;
        ListNode original = head;
        ListNode n = null;
        ListNode originalN = null;
        while (head != null) {
            if (head.val < x) {
                firstPointer = Math.min(firstPointer, lastPointer);
                if (n == null) {
                    n = new ListNode(head.val);
                    originalN = n;
                } else {
                    n.next = new ListNode(head.val);
                    n = n.next;

                }
                head = head.next;
                if (prev != null)
                    prev.next = head;
            } else {
                prev = head;
                head = head.next;
            }
            lastPointer++;
        }

        while (original != null) {
            if (original.val < x) {
                original = original.next;
                continue;
            }
            if (n == null) {
                n = new ListNode(original.val);
                originalN = n;
            } else {
                n.next = new ListNode(original.val);
                n = n.next;
            }
            original = original.next;
        }

        return originalN;

    }
}
