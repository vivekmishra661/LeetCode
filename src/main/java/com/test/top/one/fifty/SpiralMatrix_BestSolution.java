package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_BestSolution {

    public List<Integer> spiralOrder(int[][] matrix) {

        //{row,column
        int[] currentLeftTop = new int[]{1, 0};
        int[] currentRightTop = new int[]{0, matrix[0].length - 1};
        int[] currentLeftBottom = new int[]{matrix.length - 1, 0};
        int[] currentRightBottom = new int[]{matrix.length - 1, matrix[0].length - 1};
        List<Integer> x = new ArrayList<>();
        int i = 0;//row
        int j = -1;//column
        String directing = "right";

        for (int k = 0; k < matrix[0].length * matrix.length; k++) {
            if (directing.equals("right")) {
                j++;
                x.add(matrix[i][j]);
                if (j == currentRightTop[1]) {
                    currentRightTop[1] = currentRightTop[1] - 1;
                    currentRightBottom[1] = currentRightBottom[1] - 1;
                    directing = "down";
                }
            } else if (directing.equals("left")) {
                j--;
                x.add(matrix[i][j]);
                if (j == currentLeftBottom[1]) {
                    currentLeftTop[1] = currentLeftTop[1] + 1;
                    currentLeftBottom[1] = currentLeftBottom[1] + 1;
                    directing = "up";
                }
            } else if (directing.equals("down")) {
                i++;
                x.add(matrix[i][j]);
                if (i == currentRightBottom[0]) {
                    currentRightBottom[0] = currentRightBottom[0] - 1;
                    currentLeftBottom[0] = currentLeftBottom[0] - 1;
                    directing = "left";
                }
            } else if (directing.equals("up")) {
                i--;
                x.add(matrix[i][j]);
                if (i == currentLeftTop[0]) {
                    currentLeftTop[0] = currentLeftTop[0] + 1;
                    currentRightTop[0] = currentRightTop[0] + 1;
                    directing = "right";
                }
            }

        }
        return x;
    }

}
