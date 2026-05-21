package com.test.top.one.fifty;

public class MinSubArrayLen_OptimumSolution {

    static void main() {
        MinSubArrayLen_OptimumSolution m = new MinSubArrayLen_OptimumSolution();
        System.out.println(m.minSubArrayLen2(15, new int[]{5,1,3,5,10,7,4,9,2,8}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int leftIndex = 0;
        int rightIndex = 0;
        int total = 0;
        int minLength = 0;
        boolean isInitial = true;
        while(true) {
            isInitial =false;
            total += nums[rightIndex];
            if(total < target && rightIndex == nums.length-1){
                break;
            }
            if (total == target) {
                if (minLength==0 || minLength > (rightIndex - leftIndex)) {
                    System.out.println(rightIndex +" "+ leftIndex);
                    minLength = (rightIndex - leftIndex)+1;
                }
                total -= nums[leftIndex];
                leftIndex++;
                rightIndex++;
                if(rightIndex== nums.length){
                    rightIndex--;
                    total-=nums[rightIndex];
                }
            } else if (total > target) {
                total -= nums[leftIndex];
                total -= nums[rightIndex];
                leftIndex++;
            } else  {
                rightIndex++;
                if(rightIndex== nums.length){
                    rightIndex--;
                    total-=nums[rightIndex];
                }
            }
        }

        return minLength;

    }

    public int minSubArrayLen2(int target, int[] nums) {
        int leftIndex = 0;
        int rightIndex = 0;
        int total = 0;
        int minLength = 0;
        while(leftIndex< nums.length && rightIndex< nums.length) {
            total += nums[rightIndex];
            if(total < target && rightIndex == nums.length-1){
                break;
            }
            if (total >= target ) {
                if (minLength==0 || minLength > (rightIndex - leftIndex)) {
                    System.out.println(rightIndex +" "+ leftIndex);
                    minLength = (rightIndex - leftIndex)+1;
                }
                total -= nums[leftIndex];
                leftIndex++;
                total-=nums[rightIndex];
            }  else  {
                rightIndex++;
                if(rightIndex== nums.length){
                    rightIndex--;
                    total-=nums[rightIndex];
                }
            }
        }

        return minLength;
    }
}
