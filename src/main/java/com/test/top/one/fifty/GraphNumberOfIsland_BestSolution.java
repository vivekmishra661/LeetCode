package com.test.top.one.fifty;

public class GraphNumberOfIsland_BestSolution {


    static void main() {
        GraphNumberOfIsland_BestSolution graphNumberOfIsland = new GraphNumberOfIsland_BestSolution();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        graphNumberOfIsland.numIslands(grid);
    }

    // x is rows y is columns
    //['1','1','1','1','0'],
    //  ['1','1','0','1','0'],
    //  ['1','1','0','0','0'],
    //  ['0','0','0','0','0']
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) { // i is x  -> rows
            for (int column = 0; column < grid[0].length; column++) {// j is y -> columns
                if (grid[row][column] == '1') {
                    count++;
                    sinkIsland(row, column, grid);
                }
            }
        }
        return count;
    }

    private void sinkIsland(int row, int column, char[][] grid) {
        int[] cordinateUp = new int[]{row-1, column};
        int[] cordinateDown = new int[]{row+1, column};
        int[] cordinateLeft = new int[]{row, column - 1};
        int[] cordinateRight = new int[]{row, column + 1};
        int columnLength = grid[0].length;
        int rowLength = grid.length;
        //UP call
        if (cordinateUp[0] >= 0) {
            if (grid[cordinateUp[0]][cordinateUp[1]] == '1') {
                grid[cordinateUp[0]][cordinateUp[1]] = '0';
                sinkIsland(cordinateUp[0] , cordinateUp[1], grid);
            }
        }

        //down call
        if (cordinateDown[0] < rowLength) {
            if (grid[cordinateDown[0]][cordinateDown[1]] == '1') {
                grid[cordinateDown[0]][cordinateDown[1]] = '0';
                sinkIsland(cordinateDown[0] , cordinateDown[1], grid);
            }
        }

        //left call
        if (cordinateLeft[1] >= 0) {
            if (grid[cordinateLeft[0]][cordinateLeft[1]] == '1') {
                grid[cordinateLeft[0]][cordinateLeft[1]] = '0';
                sinkIsland(cordinateLeft[0], cordinateLeft[1] , grid);
            }
        }

        //right call
        if (cordinateRight[1] < columnLength) {
            if (grid[cordinateRight[0]][cordinateRight[1]] == '1') {
                grid[cordinateRight[0]][cordinateRight[1]] = '0';
                sinkIsland(cordinateRight[0], cordinateRight[1] , grid);
            }
        }

    }
}

