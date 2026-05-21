package com.test.top.one.fifty;

import java.util.TreeSet;

public class LongestConsequtive_Recheck {

    static void main() {
        LongestConsequtive_Recheck l = new LongestConsequtive_Recheck();
        l.longestConsecutive(new int[]{1,2,6,7,8});

    }

    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        TreeSet<Integer> s =new TreeSet<>();
        for(int i = 0;i<nums.length;i++){
            s.add(nums[i]);
        }

        var t = s.iterator();
        int count =0;
        int maxCount = 0;
        int prev = s.first();
        while (t.hasNext()){
            var n = t.next();
            if(prev == n){
                count++;
                continue;

            }
            if(n-prev>1){
                if(maxCount<count){
                    maxCount = count;
                }
                prev = n;
                count=1;
            }else{
                count++;
                prev = n;
            }

        }

        return Math.max(maxCount, count);
    }
}
