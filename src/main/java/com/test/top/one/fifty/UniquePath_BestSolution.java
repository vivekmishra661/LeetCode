package com.test.top.one.fifty;

public class UniquePath_BestSolution {

    static void main() {
        UniquePath_BestSolution uniquePath = new UniquePath_BestSolution();
        int zx = uniquePath.findPath(4, 5);
        System.out.println(zx);
    }

    public int findPath(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        return helper(m, n, dp);
    }

    private int helper(int m, int n, int[][] dp) {
        if (dp[m][n] != 0) {
            return dp[m][n];
        }
        if (m == 1 || n == 1) {
            dp[m][n] = 1;
            return 1;
        }
        dp[m][n] = helper(m - 1, n, dp) + helper(m, n - 1, dp);
        return dp[m][n];
    }

    public int findPathWithoutRecursion(int m , int n){
        int[][] dp = new int[m][n];
        for(int i = 0; i< m;i++){
            for(int j = 0; j< n; j++){
               dp[i][j] =1;
            }
        }
        for(int r = m-2; r>=0; r--){
            for(int k = n-2; k>=0; r-- ){
                dp[r][k] = dp[r+1][k] + dp[r][k+1];
            }
        }
        return dp[0][0];
    }
}
