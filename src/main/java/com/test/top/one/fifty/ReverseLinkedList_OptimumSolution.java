package com.test.top.one.fifty;

import org.example.ListNode;

public class ReverseLinkedList_OptimumSolution {

    static void main() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ReverseLinkedList_OptimumSolution reverseLinkedList = new ReverseLinkedList_OptimumSolution();
        reverseLinkedList.reverseBetween(l1, 3,4);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

      int count =1;
      ListNode last  = null;
      if(left==right){
          return head;
      }
      ListNode x = head;
      while(true){
          System.out.println(head.val);
          if(left>count){
              count++;
              last  = head;
              head = head.next;
              continue;
          }else if(count> right-1){
              break;
          }else{
              if(last!= null){
                  var currentElement = head;
                  var secondIndexElement  = last.next;
                  var elementToMoveToSecondIndex = head.next;
                  var elementToAttachCurrent = head.next.next;
                  last.next = elementToMoveToSecondIndex;
                  elementToMoveToSecondIndex.next = secondIndexElement;
                  currentElement.next = elementToAttachCurrent;
                  count++;
               //   head = head.next;
              }else{
                  var currentElement = head;
                  var elementToAttachFirst = head.next;
                  var elementToAttachCurrent = head.next.next;
                  if(x== null) {
                      x = elementToAttachFirst;
                      elementToAttachFirst.next = currentElement;
                  }else{
                      var currentFirstElement  = x;
                      x = elementToAttachFirst;
                      elementToAttachFirst.next = currentFirstElement;
                  }
                  currentElement.next = elementToAttachCurrent;
                  count++;
              }

          }
      }

        return x;
    }
}
