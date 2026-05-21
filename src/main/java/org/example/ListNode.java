package org.example;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

   /* @Override
    public String toString() {
        StringBuilder s= new StringBuilder();
        var t = this;
        while(t!= null){
            s.append(t.val);
            s.append("->");
            t = t.next;
        }
        return s.toString();
    }*/
}
