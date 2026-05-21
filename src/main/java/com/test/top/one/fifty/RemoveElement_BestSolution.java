package com.test.top.one.fifty;

public class RemoveElement_BestSolution {

    static void main() {

    }

    public int removeElement(int[] nums, int val) {
        int endIndex = nums.length-1;
        for(int i = nums.length-1;i>=0;i--){

            if(nums[i] == val){
                if(i == endIndex){
                    nums[i] = 0;
                }else {
                    nums[i] = nums[endIndex];
                }
                endIndex--;
            }
        }
        return endIndex+1;
    }
}
