package com.test.top.one.fifty;

public class RemoveDuplicateSecond_OptimumSolution {

    static void main() {
        RemoveDuplicateSecond_OptimumSolution.removeDuplicates_better(new int[]{1,1,1,2,2,3});
    }

    public static int removeDuplicates(int[] nums) {
        int endIndex = nums.length - 1;
        int cc = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[endIndex] == nums[i] && cc<2){
                int x = nums[i];
                nums[i] = 0;
                nums[endIndex-1] = x;
                cc++;
                endIndex--;
            }else if(nums[endIndex] == nums[i] && cc==2){
                nums[i]=0;
            }else if(nums[endIndex] != nums[i] ){
                if( (endIndex-1) != i){
                    nums[endIndex-1] = nums[i];
                    nums[i] = 0;
                }
                cc=1;
                endIndex--;
            }
        }
        int count = 0;
        for (int i = endIndex; i < nums.length; i++) {
            nums[count] = nums[i];
            if (count != i)
                nums[i] = 0;
            count++;
        }

        return count;
    }

    public static int removeDuplicates_better(int[] nums) {
        int startInde = 0;
        int cc = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[startInde] == nums[i] && cc<2){
                int x = nums[i];
                nums[i] = 0;
                nums[startInde+1] = x;
                cc++;
                startInde++;
            }else if(nums[startInde] == nums[i] && cc==2){
                nums[i]=0;
            }else if(nums[startInde] != nums[i] ){
                if( (startInde+1) != i){
                    nums[startInde+1] = nums[i];
                    nums[i] = 0;
                }
                cc=1;
                startInde++;
            }
        }


        return startInde+1;
    }

}
