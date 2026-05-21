package com.test.top.one.fifty;

import java.util.HashSet;

public class ValidSudoku_OptimumSolution {

    static void main() {
        //[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
        //[["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
        ValidSudoku_OptimumSolution validSudoku = new ValidSudoku_OptimumSolution();
        System.out.println(validSudoku.isValidSudoku(new char[][]
                {{'5','3','.','.','7','.','.','.','.'},
                 {'6','.','.','1','9','5','.','.','.'},
                 {'.','9','8','.','.','.','.','6','.'},
                 {'8','.','.','.','6','.','.','.','3'},
                  {'4','.','.','8','.','3','.','.','1'},
                 {'7','.','.','.','2','.','.','.','6'},
                 {'.','6','.','.','.','.','2','8','.'},
                 {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}}));
       // {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
    }

    public boolean isValidSudoku(char[][] board){

        int k = 0;
        int l = 0;
        int originalL = 0;
        int originalK = 0;
        for(int i = 0 ;  i < board.length; i++){

            if(i> 0 && i%3==0){
                k =i;
                l=0;
                originalL = l;
                originalK = k;
            }
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> smallMatrix = new HashSet<>();
            for(int j = 0 ;  j < board.length; j++){

                if (l >0 && l  % 3 ==0) {
                    l = originalL;
                    k = k + 1;
                }

                System.out.println( i + " " + j +" "+ k + " "+ l);



                if (board[j][i] != '.') {
                    if (row.contains(board[j][i])) {
                        System.out.println("a");
                        return false;
                    } else {
                        row.add(board[j][i]);
                    }
                }
                if (board[i][j] != '.') {
                    if (column.contains(board[i][j])) {
                        System.out.println("b");
                        return false;
                    } else {
                        column.add(board[i][j]);
                    }
                }

                if (board[k][l] != '.') {
                    if (smallMatrix.contains(board[k][l])) {
                        System.out.println("c");
                        return false;
                    } else {
                        smallMatrix.add(board[k][l]);
                    }
                }
                l++;
            }

            originalL = l;
            k = originalK-1;

        }

        return true;
    }



}
