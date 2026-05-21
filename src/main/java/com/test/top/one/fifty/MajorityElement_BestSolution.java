package com.test.top.one.fifty;

public class MajorityElement_BestSolution {

    static void main() {
        System.out.println(majorityElement(new int[]{2,2,3,1,1,1,2,1,2,}));
    }

    public static int majorityElement(int[] nums) {

        int currentElement  = nums[0];
        int count= 0;
        for(int i=0;i<nums.length;i++){
            if(count ==0){
                currentElement = nums[i];
            }
            if(nums[i] == currentElement){
                count++;
            }else{
                count--;
            }
        }
        return currentElement;
    }
}
