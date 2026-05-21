package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {


    static void main() {
        InsertInterval insertInterval = new InsertInterval();
        insertInterval.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        //0 2 4 6 8 10  -> 1-3
        if (newInterval[0] < intervals[0][0] && newInterval[1] > intervals[intervals.length - 1][1]) {
            intervals[0][0] = newInterval[0];
            intervals[intervals.length - 1][1] = newInterval[1];
            return intervals;
        }

        List<int[]> k = new ArrayList<>();
        boolean isRunning = false;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                return intervals;
            }


            // 4-5 1-2
            if (newInterval[1] > intervals[i][1] && newInterval[0]> intervals[i][1]) {
                k.add(new int[]{intervals[i][0], intervals[i][1]});
            } else if (newInterval[0] < intervals[i][0] && newInterval[1] < intervals[i][1]) {
                k.add(new int[]{intervals[i][0], intervals[i][1]});
            } else if (newInterval[0] >= intervals[i][0] && newInterval[1] < intervals[i][1]) {
                k.add(new int[]{intervals[i][0], newInterval[1]});
                isRunning = true;
            } else {
                if (isRunning && newInterval[1] <= intervals[i][1]) {
                    var last = k.getLast();
                    last[1] = Math.max(newInterval[1], intervals[i][1]);
                    isRunning = false;
                }
            }
        }
        return k.toArray(new int[0][0]);

    }
}
