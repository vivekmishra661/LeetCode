package com.test.top.one.fifty;

public class RemoveDuplicate_OptimumSolution {
    static void main() {
        //[1,1,2,2,3,4,5,5,5]
        System.out.println(removeDuplicates(new int[]{1}));
    }

    public static int removeDuplicates(int[] nums) {
        int endIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[endIndex] == nums[i]) {
                nums[i] = 0;
            } else {
                if (endIndex - 1 != i) {
                    nums[endIndex - 1] = nums[i];
                    nums[i] = 0;
                }
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
}
