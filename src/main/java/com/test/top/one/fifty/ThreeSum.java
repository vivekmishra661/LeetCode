package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> minHeap = new ArrayList<>();
        List<Integer> maxHeap = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                minHeap.add(nums[i]);
            } else if (nums[i] < 0) {
                maxHeap.add(nums[i]);
            }
        }
        minHeap.sort((a, b) -> b-a);
        maxHeap.sort(Comparator.naturalOrder());

       /* for(int i = ; i< minHeap.size(); i++){

        }*/

        return null;


    }
}
