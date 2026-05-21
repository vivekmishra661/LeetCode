package com.test.top.one.fifty;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class KSmallPair {

    static void main() {
        KSmallPair kSmallPair = new KSmallPair();
        kSmallPair.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3} , 2);
    }

    class T implements Comparable<T> {
        int index1;
        int index2;
        int total;

        public T(int index1 , int index2){
            this.index1 = index1;
            this.index2 = index2;
            total = index1 + index2;
        }

        @Override
        public int compareTo(T o) {
            return this.total-o.total;
        }


    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<T> priorityQueue = new PriorityQueue<>(k);
        AtomicInteger i1 =new AtomicInteger(0);
        AtomicInteger i2= new AtomicInteger(0);
        while(true){
           priorityQueue.offer(new T(nums1[i1.get()], nums2[i2.get()]));
           findnextSeq(nums1,nums2, i1,i2);
           if(priorityQueue.size()== k) break;
        }

        List<List<Integer>> finalList = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            T t = priorityQueue.poll();
            finalList.add(List.of(t.index1, t.index2));
        }
        return  finalList;
    }

    private void findnextSeq(int[] nums1, int[] nums2, AtomicInteger i1, AtomicInteger i2) {
        if(nums1[i1.get()]>nums2[i2.get()]){
           i1.incrementAndGet();
        }else if(nums2[i2.get()]> nums1[i1.get()] ){
            i2.incrementAndGet();
        }else{
            if(nums1[i1.get()+1]> nums2[i2.get()+1]){
                i2.incrementAndGet();
            }else if(nums2[i2.get()+1]> nums1[i1.get()+1] ){
                i1.incrementAndGet();
            }
        }


    }
}
