package com.test.top.one.fifty;

import org.example.ListNode;

public class RotateRight_BestSolution {

    static void main() {
        RotateRight_BestSolution l = new RotateRight_BestSolution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l.rotateRight(l1, 5);
    }

    public ListNode rotateRight(ListNode head, int k) {
        int count = 1;
        ListNode full = head;

        if(head == null || head.next== null || k==0){
            return head;
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
        k = k % count;
        if (k == 0) {
            return full;
        }

        int first = count - k +1;
        head = full;
        count = 1;
        ListNode dataToAdd = null;
        while (head != null) {
            if(first ==1){
                full = full;
                break;
            }
            var next = head.next;  //count 1 first 3
            if (next != null && first == count +1) {  //count 1
               // head is previous
                dataToAdd = next;
                head.next = null;
                break;
            } else if (next != null) {
                var nextToNext = next.next;
                if (nextToNext != null && first == count + 2) {//count 1 first 3
                   //next is previous
                    dataToAdd = nextToNext;
                    next.next = null;
                    break;
                }
            }
            head = head.next.next;
            count = count+2;

        }
        head= dataToAdd;
        while (head != null) {
            var next = head.next;
            if (next != null) {
                var nextToNext = next.next;
                if (nextToNext != null) {
                    count += 2;
                    head = nextToNext;
                } else {
                    count += 1;
                    head.next.next = full;
                    break;
                }
            } else {
                head.next =full;
                break;
            }
        }

        return dataToAdd;
    }
}
