package com.test.top.one.fifty;

public class UniquePathWithObstacles_BestSolution {

    static void main() {
        UniquePathWithObstacles_BestSolution uniquePathWithObstacles = new UniquePathWithObstacles_BestSolution();
        int val = uniquePathWithObstacles.uniquePathsWithObstacles(new int[][]
                        {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}
                //     {{0,1},{0,0}}
                //{{1}, {0}}
        );
        System.out.println(val);
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        Integer[][] dp = new Integer[m][n];
        return recur(obstacleGrid, dp, m - 1, n - 1);

    }

    public int recur(int[][] obstacles, Integer[][] dp, int m, int n) {

        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0 || obstacles[m][n] == 1) {
            return 0;
        }
        if (dp[m][n] != null) {
            return dp[m][n];
        }

        dp[m][n] = recur(obstacles, dp, m - 1, n) + recur(obstacles, dp, m, n - 1);
        return dp[m][n];

    }


}
