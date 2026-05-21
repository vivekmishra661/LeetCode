package com.test.top.one.fifty;

import java.util.concurrent.atomic.AtomicInteger;

public class MaximalSquare {

    static void main() {
        MaximalSquare maximalSquare = new MaximalSquare();
        maximalSquare.maximalSquare(new char[][]{
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}});
    }

    public int maximalSquare(char[][] matrix) {
        AtomicInteger currentMax = new AtomicInteger(0);
        AtomicInteger totalMax = new AtomicInteger(0);
        AtomicInteger currentCount = new AtomicInteger(0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    System.out.println("starting new with index" + i + " " + j);
                    currentCount.set(1);
                    currentMax.set(1);
                    var newindex = recur(currentCount, new int[]{i, j}, matrix, currentMax, totalMax);
                   // i = newindex[0];
                    j = newindex[1];
                    if(totalMax.get() == matrix.length || totalMax.get() == matrix[0].length){
                        return totalMax.get()*totalMax.get();
                    }
                }
            }
        }
        return totalMax.get()*totalMax.get();
    }


    public int[] recur(AtomicInteger currentCount, int[] index, char[][] matrix,
                      AtomicInteger currentMax, AtomicInteger totalMax) {
        if (index[0] + currentCount.get() == matrix.length || index[1] + currentCount.get() == matrix[0].length) {
            if (currentMax.get() > totalMax.get()) {
                totalMax.set(currentMax.get());
                currentMax.set(0);
            }
            return new int [] {index[0] + currentCount.get()-1, index[1] + currentCount.get()-1};
        }
        for (int i = 0; i <= currentCount.get(); i++) {
            System.out.println("[][] " + ((int) (index[0] + currentCount.get())) + " " + ((int) (index[1] + i)));
            if (matrix[index[0] + currentCount.get()][index[1] + i] == '1') {
                continue;
            } else {
                if (currentMax.get() > totalMax.get()) {
                    totalMax.set(currentMax.get());
                    currentMax.set(0);
                }
                return new int[] {index[0] + currentCount.get(),index[1] + i};
            }
        }
        for (int i = 0; i <= currentCount.get(); i++) {
            System.out.println("[][] " + ((int) (index[0] + i)) + " " + ((int) (index[1] + currentCount.get())));
            if (matrix[index[0] + i][index[1] + currentCount.get()] == '1') {
                continue;
            } else {
                if (currentMax.get() > totalMax.get()) {
                    totalMax.set(currentMax.get());
                    currentMax.set(0);
                }
                return new int[] {index[0] + i, index[1] + currentCount.get()};
            }
        }
        currentMax.getAndIncrement();
        currentCount.getAndIncrement();
        recur(currentCount, index, matrix, currentMax, totalMax);
        return index;
    }
}
