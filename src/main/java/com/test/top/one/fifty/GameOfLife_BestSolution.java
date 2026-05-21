package com.test.top.one.fifty;

public class GameOfLife_BestSolution {

    static void main() {
        GameOfLife_BestSolution gameOfLife = new GameOfLife_BestSolution();
        gameOfLife.gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }

    public void gameOfLife(int[][] board) {
        //0 changes to
        //1 change to 10
        //0 -> 0%10  = 0
        //1 -> 1%10 = 1
        //1 -> 101%10 = 1
        //0 -> 10%10 = 0

        //0, 1, 101, 10

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int total = 0;

                if (i > 0 && j > 0)
                    total += ((int) (board[i - 1][j - 1]) % 10);
                if (i > 0)
                    total += ((int) (board[i - 1][j]) % 10);
                if (i > 0 && j < board[0].length - 1)
                    total += ((int) (board[i - 1][j + 1]) % 10);
                if (i < board.length - 1 && j > 0)
                    total += ((int) (board[i + 1][j - 1]) % 10);
                if (i < board.length - 1)
                    total += ((int) (board[i + 1][j]) % 10);
                if (i < board.length - 1 && j < board[0].length - 1)
                    total += ((int) (board[i + 1][j + 1]) % 10);
                if (j > 0)
                    total += ((int) (board[i][j - 1]) % 10);
                if (j < board[0].length - 1)
                    total += ((int) (board[i][j + 1]) % 10);
                if (board[i][j] == 1 && (total < 2 || total > 3)) {
                    board[i][j] = 101;
                } else if (board[i][j] == 0 && total == 3) {
                    board[i][j] = 10;
                }


            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {


                if (board[i][j] == 101) {
                    board[i][j] = 0;
                } else if (board[i][j] == 10) {
                    board[i][j] = 1;
                }


            }
        }


    }
}
