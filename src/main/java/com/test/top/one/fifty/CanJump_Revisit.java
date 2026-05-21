package com.test.top.one.fifty;

public class CanJump_Revisit {

    static void main() {
        System.out.println(CanJump_Revisit.canJump2(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
    }

    public static boolean canJump(int[] nums) {
        //2,3,1,1,4 -- use greedy
        int i = 0;
        int n = 0;
        int endIndex = nums.length-1;
        int currentElement  = nums[0];
        while(i<=endIndex){
            if(nums[i]>= endIndex-i || currentElement-n >= endIndex-i) return true;
            if(currentElement-n <= 0 && nums[i] ==0) return false;
            if(currentElement-n< nums[i]){
                currentElement = nums[i];
                n=1;
            }else{
                n++;
            }
            i++;
        }
        return true;
    }

    public static int canJump2(int[] nums) {
        //this is brute force complexity 0(n^2)
       int jumps = 0;
       int endIndex = nums.length-1;
       boolean founnd = false;
       while(!founnd){
           if(endIndex==0){
               founnd =true;
               break;
           }
           for(int i = 0; i<=endIndex; i++){
               if(nums[i]>=endIndex-i){
                   endIndex = i;
                   jumps++;
                   break;
               }
           }
       }
       return jumps;
    }
}
