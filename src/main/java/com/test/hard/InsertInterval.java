package com.test.hard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InsertInterval {

    static void main() {
        InsertInterval insertInterval = new InsertInterval();
        insertInterval.insert(new int[][]{{2, 5}, {6, 7},{8,9}}, new int[]{0,1});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) {
            return intervals;
        } else if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<Integer[]> data = new ArrayList<>();
        boolean isAdded = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!isAdded && newInterval[0] < intervals[i][0]) {
                data.add(new Integer[]{newInterval[0], newInterval[1]});
                isAdded =true;
            }
            if (newInterval[0] >= intervals[i][0] && newInterval[0] < intervals[i][1]) {
                data.add(new Integer[]{intervals[i][0], intervals[i][1]});
                if (intervals[i][1] < newInterval[1]) {
                    data.getLast()[1] = newInterval[1];
                }
                isAdded = true;
            } else {
                data.add(new Integer[]{intervals[i][0], intervals[i][1]});
            }
            if (!isAdded && i == intervals.length - 1 && newInterval[0] > intervals[i][0]) {
                data.add(new Integer[]{newInterval[0], newInterval[1]});
                isAdded =true;
            }
        }
        Iterator<Integer[]> iterator = data.iterator();
        Integer[] previous = null;
        while (iterator.hasNext()) {
            var current = iterator.next();
            if (previous != null) {
                if (previous[1] >= current[0] && previous[1] < current[1]) {
                    previous[1] = current[1];
                    iterator.remove();
                    continue;
                } else if (previous[0] <= current[0] && previous[1] >= current[1]) {
                    iterator.remove();
                    continue;
                }
            }
            previous = current;
        }

        int[][] result = new int[data.size()][2];
        for (int j = 0; j < data.size(); j++) {
            result[j] = new int[]{data.get(j)[0], data.get(j)[1]};
        }
        return result;
    }
}
