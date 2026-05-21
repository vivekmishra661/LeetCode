package com.test.top.one.fifty;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_BestSolution {

    static void main() {
        LRUCache_BestSolution lruCache = new LRUCache_BestSolution(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        //System.out.println(lruCache.get(1));
        lruCache.put(2,3);
       // System.out.println(lruCache.get(2));
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
      //  System.out.println(lruCache.get(4));
    }

    class Node {
        int key;
        int value;
        Node previous;
        Node next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int maxCapacity =0;
    private int currentCapacity =0;
    private Map<Integer, Node> cache = new HashMap<>();
    private Node head;
    private Node tail;

    public LRUCache_BestSolution(int n){
        this.maxCapacity = n;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;


    }


    public int get(int key) {
       if(cache.get(key)!= null){
           var node=  cache.get(key);
           //removed node from current place
           var previousNode = node.previous;
           var nextNode = node.next;
           previousNode.next = nextNode;
           nextNode.previous = previousNode;
           //adding it to top of head
           var headNext = head.next;
           head.next = node;
           node.previous = head;
           headNext.previous = node;
           node.next = headNext;
           return node.value;
       }
       return -1;
    }

    public void put(int key, int value){
        if(cache.get(key) ==null){
            var newNode = new Node(key, value);
            cache.put(key, newNode);
            //adding it to top of head
            var headNext = head.next;
            head.next = newNode;
            newNode.previous = head;
            headNext.previous = newNode;
            newNode.next = headNext;
            currentCapacity++;
        }else{
            var node = cache.get(key);
            node.value = value;
            cache.put(key, node);
            //removed node from current place
            var previousNode = node.previous;
            var nextNode = node.next;
            previousNode.next = nextNode;
            nextNode.previous = previousNode;
            //adding it to top of head
            var headNext = head.next;
            head.next = node;
            node.previous = head;
            headNext.previous = node;
            node.next = headNext;
        }

        if(currentCapacity>maxCapacity){
            var previousTail = tail.previous;
            var prevToPreviousTail = previousTail.previous;
            prevToPreviousTail.next =tail;
            tail.previous = prevToPreviousTail;
            cache.remove(previousTail.key);
            currentCapacity--;
        }

    }



}
