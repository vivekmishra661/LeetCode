package com.test.top.one.fifty;

public class RotateImage_BestSolution {

    static void main() {
        RotateImage_BestSolution rotateImage = new RotateImage_BestSolution();
        rotateImage.rotate(new int[][]
                //{{1,2,3},{4,5,6},{7,8,9}});
                {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }

    public void rotate(int[][] matrix) {
        /*for(int k = 0; k< matrix.length;k++){
            int a1 = matrix[0][k];
            int a2 = matrix[k][ matrix.length-1 ];
            int a3 = matrix [matrix.length-1] [matrix.length-1-k];
            int a4 = matrix [matrix.length-1-k] [matrix.length-1];
            matrix[k][ matrix.length-1 ] = a1;
            matrix [matrix.length-1] [matrix.length-1-k] = a2;
            matrix [matrix.length-1-k] [matrix.length-1] = a3;
            matrix[0][k] = a4;

        }*/
        rotate(matrix, 0,0, matrix.length-1, matrix.length-1);

    }

    void rotate(int[][] matrix, int rowStartIndex, int columnStartIndex, int rowEndIndex, int columnEndIndex ) {

        if(rowEndIndex<1){
            return;
        }
        for(int k = rowStartIndex; k< rowEndIndex;k++){
            int a1 = matrix[rowStartIndex][k];
            int a2 = matrix[k][ columnEndIndex ];
            int a3 = matrix [rowEndIndex] [(columnEndIndex+columnStartIndex) -k];
            int a4 = matrix [(rowEndIndex+rowStartIndex)-k] [columnStartIndex];
            matrix[k][ columnEndIndex ] = a1;
            matrix [rowEndIndex] [(columnEndIndex+columnStartIndex) -k] = a2;
            matrix [(rowEndIndex+rowStartIndex)-k] [columnStartIndex] = a3;
            matrix[rowStartIndex][k] = a4;

        }
        rowStartIndex = rowStartIndex+1;
        columnStartIndex = columnStartIndex+1;
        rowEndIndex = rowEndIndex-1;
        columnEndIndex = columnEndIndex-1;

        rotate(matrix, rowStartIndex,columnStartIndex, rowEndIndex,columnEndIndex);

    }
}
