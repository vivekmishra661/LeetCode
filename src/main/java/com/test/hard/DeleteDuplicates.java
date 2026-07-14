package com.test.hard;

import org.example.ListNode;

public class DeleteDuplicates {

    static void main() {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        var t = deleteDuplicates.deleteDuplicates(
                new ListNode(1,
                        new ListNode(1)));
        System.out.println(t.toString());
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null) return null;
        ListNode originalHead = head;
        ListNode prev = null;
        ListNode prevToPrev = null;
        Integer currentVal = null;
        boolean isMatched = false;
        while (head != null) {
            if (currentVal != null && head.val == currentVal) {
                prev.next = head.next;
                head = prev.next;
                isMatched = true;
            } else if (isMatched) {
                currentVal = head.val;
                prev = head;
                if (prevToPrev != null) {
                    prevToPrev.next = prev;
                } else {
                    originalHead = prev;
                }
                prev.next = head.next;
                head = head.next;
                isMatched = false;
            } else {
                currentVal = head.val;
                prevToPrev = prev;
                prev = head;
                head = head.next;
            }
        }
        if (isMatched) {
            prev = head;
            if (prevToPrev != null) {
                prevToPrev.next = prev;
            } else {
                originalHead = prev;
            }
        }
        return originalHead;
    }
}
