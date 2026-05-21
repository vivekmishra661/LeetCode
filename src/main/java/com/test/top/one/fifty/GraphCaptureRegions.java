package com.test.top.one.fifty;

public class GraphCaptureRegions {

    static void main() {
        GraphCaptureRegions graphNumberOfIsland = new GraphCaptureRegions();
        char[][] grid = {
                {'X', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', 'X', '0', 'X'},
                {'X', '0', 'X', 'X'}
        };
        graphNumberOfIsland.solve(grid);
        System.out.println(grid);
    }

    public void solve(char[][] board) {

    }
}
