package com.test.top.one.fifty;

import java.util.*;

public class MergeInterval_OptimumSolution {

    static void main() {
        MergeInterval_OptimumSolution mergeInterval = new MergeInterval_OptimumSolution();
        mergeInterval.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }


    public int[][] merge(int[][] intervals) {
        Queue<Integer> queue0 = new PriorityQueue<>();
        Queue<Integer> queue1 = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            queue0.offer(intervals[i][0]);
            queue1.offer(intervals[i][1]);
        }
        List<int[]> k = new ArrayList<>();
        int[] last = null;
        while (!queue0.isEmpty()) {
            var firstQ = queue0.poll();
            var lastQ = queue1.poll();
            if (last != null && last[1] >= firstQ) {
                last[1] = lastQ;
            } else {
                k.add(new int[]{firstQ, lastQ});
                last = k.getLast();
            }
        }
        return  k.toArray(new int[0][0]);


    }
}
