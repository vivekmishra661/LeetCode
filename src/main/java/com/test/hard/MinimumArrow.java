package com.test.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MinimumArrow {

    static void main() {
        MinimumArrow minimumArrow = new MinimumArrow();
        //  minimumArrow.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
        minimumArrow.findMinArrowShots(new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}});
    }

    public int findMinArrowShots(int[][] points) {

        //find overLappingRecords
        //overLappingRecords can be put in one bucket
        List<Integer[]> startIndex = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            startIndex.add(i, new Integer[]{points[i][0], points[i][1]});
        }
        startIndex.sort((e1, e2) -> {
            if (e1[0] > e2[0]) {
                return 1;
            } else if (e1[0] < e2[0]) {
                return -1;
            } else if (e1[1] > e2[1]) {
                return 1;
            } else {
                return -1;
            }
        });
        int baloonCount = 0;
        List<Integer> arrowIndex = new ArrayList<>();
        for (int i = 0; i < startIndex.size(); i++) {
            int xMin = startIndex.get(i)[0];
            int xMax = startIndex.get(i)[1];
            if (i > 0) {
                if(arrowIndex.getLast()>=xMin && arrowIndex.getLast()> xMax){
                    arrowIndex.removeLast();
                    arrowIndex.add(xMax);
                }
                else if (arrowIndex.getLast() >= xMin && arrowIndex.getLast() <= xMax) {
                    //do nothing
                }
                else {
                    baloonCount++;
                    arrowIndex.add(xMax);
                }

            } else {
                baloonCount++;
                arrowIndex.add(xMax);
            }
        }


        return baloonCount;
    }
}
