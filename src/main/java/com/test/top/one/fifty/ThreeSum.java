package com.test.top.one.fifty;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    static void main() {
        ThreeSum threeSum = new ThreeSum();
        var t  = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
        t.toString();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> minHeap = new ArrayList<>();
        List<List<Integer>> q = new ArrayList<>();
        Set<Integer> pq = new HashSet<>();
        for(int i = 0; i< nums.length;i++){
            pq.add(nums[i]);
            minHeap.add(nums[i]);
        }
        if(pq.size() ==1 && nums.length>2 && nums[0]==0){
             q.add(List.of(0,0,0));
             return q;
        }
        minHeap =  minHeap.stream().sorted().collect(Collectors.toList());

        Set<String> pp = new HashSet<>();
        for (int i = 1; i < minHeap.size() - 1; i++) {
            int pointer1 = i - 1;
            int pointer2 = i + 1;
            while (true) {
                var value = minHeap.get(i) + minHeap.get(pointer1) + minHeap.get(pointer2);
                if (value > 0) {
                    if (pointer1 > 0) {
                        pointer1--;
                    } else {
                        break;
                    }
                } else if (value < 0) {
                    if (pointer2 < minHeap.size() - 1) {
                        pointer2++;

                    } else {
                        break;
                    }
                } else {
                    var y = new ArrayList<Integer>();
                    y.add(minHeap.get(i));
                    y.add(minHeap.get(pointer1));
                    y.add(minHeap.get(pointer2));
                    var yy = y.stream().map(e -> String.valueOf(e)).collect(Collectors.joining("-"));
                    if (!pp.contains(yy)) {
                        var t = new ArrayList<Integer>();
                        t.add(minHeap.get(i));
                        t.add(minHeap.get(pointer1));
                        t.add(minHeap.get(pointer2));
                        q.add(t);
                        pp.add(yy);

                    }
                    if (pointer1 > 0) {
                        pointer1--;
                    } else {
                        break;
                    }

                    if (pointer2 < minHeap.size() - 1) {
                        pointer2++;

                    } else {
                        break;
                    }
                }
            }


        }
        return q;

    }
}
