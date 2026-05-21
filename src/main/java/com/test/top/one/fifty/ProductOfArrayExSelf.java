package com.test.top.one.fifty;

public class ProductOfArrayExSelf {



    public int[] productExceptSelf(int[] nums) {

        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];
        int x = nums.length-1;
        for(int i =0;i<nums.length;i++){
            if(i>0 && x< nums.length-1){
                prefixProduct[i] = nums[i-1] * prefixProduct[i-1];
                suffixProduct[x] = nums[x+1] * suffixProduct[x+1];
            }else{
                prefixProduct[i] = 1;
                suffixProduct[x] = 1;
            }
            x--;
        }
        int[] finall = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            finall[i] = prefixProduct[i] * suffixProduct[i];
        }
        return finall;
    }

}
