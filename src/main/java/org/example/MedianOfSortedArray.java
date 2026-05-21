package org.example;

public class MedianOfSortedArray {

    static void main() {
        MedianOfSortedArray.findMedianSortedArrays(new int[]{1,3} , new int[]{2});
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int trueIndexNums1 = 0;
        int trueIndexNums2 = 0;
        int[] nums3 = new int[nums1.length+ nums2.length];
        for(int i=0; i<nums1.length+ nums2.length; i++){
            if(nums1.length > trueIndexNums1 && nums2.length >trueIndexNums2) {
                if (nums1[trueIndexNums1] > nums2[trueIndexNums2]) {
                    nums3[i] = nums2[trueIndexNums2];
                    trueIndexNums2++;
                } else if (nums1[trueIndexNums1] < nums2[trueIndexNums2]) {
                    nums3[i] = nums1[trueIndexNums1];
                    trueIndexNums1++;
                } else if (nums1[trueIndexNums1] == nums2[trueIndexNums2]) {
                    nums3[i] = nums1[trueIndexNums1];
                    nums3[i + 1] = nums2[trueIndexNums2];
                    trueIndexNums1++;
                    trueIndexNums2++;
                    i++;
                }
            }else if(nums1.length < trueIndexNums1+1){
                nums3[i] = nums2[trueIndexNums2];
                trueIndexNums2++;
            }else if(nums2.length <trueIndexNums2+1){
                nums3[i] = nums1[trueIndexNums1];
                trueIndexNums1++;
            }
        }

        if(nums3.length%2 == 0){
            return (double) (nums3[(nums3.length)/2 -1]  + nums3[((nums3.length)/2)])/2 ;
        }else{
            return (double) nums3[(nums3.length+1)/2 - 1];
        }
    }
}
