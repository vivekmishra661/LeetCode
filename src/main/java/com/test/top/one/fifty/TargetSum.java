package com.test.top.one.fifty;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> val = new HashMap<>();
    }

    private int recur(int[][] dp, int index, int total, int[] nums, int target){
        if(index == nums.length-1 && total == target){
            return 1;
        }

        dp[index][total] = recur(dp[index+1][total+]) +
                recur(dp)
    }


}
