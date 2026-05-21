package com.test.top.one.fifty;

import java.util.HashMap;

public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> p = new HashMap<>();
        for(int i =0; i<nums.length;i++){
            if(p.get(nums[i])==null){
                p.put(nums[i], i);
            }else{
                var t = p.get(nums[i]);
                if(i-t<= k){
                    return true;
                }else{
                    p.put(nums[i],i);
                }
            }
        }
        return false;
    }
}
