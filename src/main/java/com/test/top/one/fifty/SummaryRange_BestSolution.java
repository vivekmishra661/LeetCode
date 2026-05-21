package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange_BestSolution {

    public List<String> summaryRanges(int[] nums) {
        List<String> summaryRanges = new ArrayList<>();
        if(nums.length==0){
            return summaryRanges;
        }
        int start = nums[0];
        int end = nums[0];
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]==1){
                end= nums[i+1];
            }else{
                if(start != end) {
                    summaryRanges.add(start + "->" + end);
                }else {
                    summaryRanges.add("" +start);
                }
                start = nums[i+1];
                end = nums[i+1];
            }

        }
        if(start != end) {
            summaryRanges.add(start + "->" + end);
        }else {
            summaryRanges.add("" +start);
        }
        return summaryRanges;
    }
}
