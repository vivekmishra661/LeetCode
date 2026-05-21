package com.test.top.one.fifty;

import java.util.Random;

public class KthLargestElement {

    static void main() {
        KthLargestElement kthLargestElement = new KthLargestElement();
        kthLargestElement.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},    4);
    }

    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 ){
            return -1;
        } else if (nums.length ==1) {
            return nums[0];

        }
        var target = nums.length - k;
        return quickSelect(0, nums.length-1, nums, target);

    }

    private int quickSelect(int l, int r, int[] nums, int target) {
        int i = l - 1;
        //Random rand = new Random();
        int pivotIndex = r;
        int pivot = nums[pivotIndex];
        for (int j = l; j < r; j++) {
            if (pivot >= nums[j]) {
                i++;
                int k = nums[i];
                nums[i] = nums[j];
                nums[j] = k;
            }
        }
        pivotIndex = i + 1;
        int h = nums[r];
        nums[r] = nums[pivotIndex];
        nums[pivotIndex] = h;
        if (pivotIndex == target) {
            return nums[pivotIndex];
        } else if (pivotIndex > target) {
            return quickSelect(l, pivotIndex-1, nums, target);
        } else {
            return quickSelect(pivotIndex + 1, r, nums, target);
        }

    }

}
