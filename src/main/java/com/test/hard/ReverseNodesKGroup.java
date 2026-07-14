package com.test.hard;

import org.example.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesKGroup {

    //not able to do it inplace TODO

    static void main() {
        ReverseNodesKGroup reverseNodesKGroup = new ReverseNodesKGroup();
        reverseNodesKGroup.reverseKGroup(
                new ListNode(1
                        , new ListNode(2
                        , new ListNode(3
                        , new ListNode(4
                        , new ListNode(5
                       // ,new ListNode(6)
                ))))), 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        List<Integer> stack = new ArrayList<>();
        int index = 0;
        ListNode l = null;
        ListNode startNode = null;
        while (head != null) {
            stack.add(head.val);
            head = head.next;
            index++;
            if (index % k == 0) {
                for (int j = stack.size() - 1; j >= 0; j--) {
                    if (l == null) {
                        l = new ListNode(stack.get(j));
                        startNode =l;
                    } else {
                        l.next = new ListNode(stack.get(j));
                        l = l.next;
                    }
                }
                stack.clear();
            }
        }
        if (!stack.isEmpty()) {
            for (int j = 0; j < stack.size(); j++) {
                if (l == null) {
                    l = new ListNode(stack.get(j));
                } else {
                    l.next = new ListNode(stack.get(j));
                    l = l.next;
                }
            }
        }
        return startNode;
    }
}
