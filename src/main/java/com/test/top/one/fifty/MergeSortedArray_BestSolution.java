package com.test.top.one.fifty;

import java.util.Arrays;

//[1,2,2,3,5,6]
//[2,0,0]

public class MergeSortedArray_BestSolution {

    static void main() {
        int[] nums1 = new int[]{0,0,3,0,0,0,0,0,0};
        MergeSortedArray_BestSolution.merge(nums1, 3, new int[]{-1,1,1,1,2,3}, 6);
        Arrays.stream(nums1).forEach(System.out::println);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1 = m - 1;
        int index2 = n - 1;

        for (int i = (m + n - 1); i >= 0; i--) {
            if (index1 < 0) {
                for (int k = 0; k <= index2; k++) {
                    nums1[k] = nums2[k];
                }
                return;
            } else if (index2 < 0) return;

            if (nums1[index1] > nums2[index2]) {
                nums1[i] = nums1[index1];
                index1--;
            } else if (nums1[index1] < nums2[index2]) {
                nums1[i] = nums2[index2];
                nums2[index2] = 0;
                index2--;
            } else if (nums1[index1] == nums2[index2]) {
                nums1[i] = nums2[index2];
                var tt = nums1[index1];
                nums1[index1] = 0;
                nums1[i-1] = tt;
                i--;
                index1--;
                index2--;
            }
        }

    }
}
