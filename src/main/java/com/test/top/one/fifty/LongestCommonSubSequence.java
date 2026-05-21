package com.test.top.one.fifty;

public class LongestCommonSubSequence {

    static void main() {
        LongestCommonSubSequence longestCommonSubSequence = new LongestCommonSubSequence();
        longestCommonSubSequence.find("abcde", "ace");
    }

    public int find(String word1, String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i= word1.length()-1; i>=0;i--){
            for(int j =word2.length()-1;j>=0;j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
