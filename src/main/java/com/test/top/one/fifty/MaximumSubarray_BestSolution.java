package com.test.top.one.fifty;

public class MaximumSubarray_BestSolution {

    static void main() {
        MaximumSubarray_BestSolution maximumSubarray = new MaximumSubarray_BestSolution();
        var t = Math.max(-1,-2);
        maximumSubarray.maxSubArray(new int[]{-1,-2});

    }

    public int maxSubArray(int[] nums) {
        int max= nums[0];
        int currentMax = nums[0];
        for(int i = 1;i<nums.length;i++){
            currentMax = Math.max(nums[i],nums[i]+ currentMax);
            max = Math.max(currentMax, max);
        }
        return Math.max(currentMax, max);
    }
}
