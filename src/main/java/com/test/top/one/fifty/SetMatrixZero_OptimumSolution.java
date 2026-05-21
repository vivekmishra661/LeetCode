package com.test.top.one.fifty;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMatrixZero_OptimumSolution   {

    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for(int i =0;i< matrix.length;i++){
            for(int j = 0; j< matrix[0].length;j++){
                if(matrix[i][j] ==0){
                    row.add(i);
                    column.add(j);
                }
            }
        }
        Iterator<Integer> t = row.iterator();
        while(t.hasNext() ){
            var k = t.next();
            for(int j = 0; j< matrix[0].length;j++){
                matrix[k][j] =0;
            }

        }

        t = column.iterator();
        while(t.hasNext() ){
            var k = t.next();
            for(int j = 0; j< matrix.length;j++){
                matrix[j][k] =0;
            }

        }
    }
}
